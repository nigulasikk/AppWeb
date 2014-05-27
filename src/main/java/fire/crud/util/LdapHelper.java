package fire.crud.util;
import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Hashtable;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.naming.Context;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import javax.naming.directory.DirContext;
import javax.naming.directory.InitialDirContext;
import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;


public class LdapHelper {

    private static DirContext ctx;

    @SuppressWarnings(value = "unchecked")
    public static DirContext getCtx() {
//        if (ctx != null ) {
//            return ctx;
//        }
        String account = "cn=Manager,dc=ccntgrid,dc=org"; //binddn 
        String password = "ccntgrid";    //bindpwd
        String root = "dc=ccntgrid,dc=org"; // root
        Hashtable env = new Hashtable();
        env.put(Context.INITIAL_CONTEXT_FACTORY, "com.sun.jndi.ldap.LdapCtxFactory");
        env.put(Context.PROVIDER_URL, "ldap://ldap.ccntgrid.org:389/" + root);
        env.put(Context.SECURITY_AUTHENTICATION, "simple");
        env.put(Context.SECURITY_PRINCIPAL, account );
        env.put(Context.SECURITY_CREDENTIALS, password);
        try {
            // 链接ldap
            ctx = new InitialDirContext(env);
            System.out.println("认证成功");
        } catch (javax.naming.AuthenticationException e) {
            System.out.println("认证失败");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("认证出错：");
            e.printStackTrace();
        }
        return ctx;
    }
    
    public static void closeCtx(){
        try {
            ctx.close();
        } catch (NamingException ex) {
            Logger.getLogger(LdapHelper.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    

    public static void main(String[] args) throws NamingException, NoSuchAlgorithmException {
        
        ctx = LdapHelper.getCtx();
        SearchControls constraints = new SearchControls();
        constraints.setSearchScope(SearchControls.SUBTREE_SCOPE);
        // constraints.setSearchScope(SearchControls.ONELEVEL_SCOPE);
        NamingEnumeration en = ctx.search("", "mail=*@ccntgrid.org", constraints); // 查询所有用户

        while (en != null && en.hasMoreElements()) {
         Object obj = en.nextElement();
         if (obj instanceof SearchResult) {
             SearchResult si = (SearchResult) obj;
             System.out.println("name:   " + si.getName());
             Attributes attrs = si.getAttributes();
             
             
             if (attrs == null) {
                 System.out.println("No   attributes");
             } else {
                 Attribute attr = attrs.get("userPassword");
                 Object o = attr.get();
                 byte[] s = (byte[]) o;
                 String pwd2 = new String(s);
                 System.out.println(pwd2);
//                 success = LdapHelper.verifySHA(pwd2, pwd);
                 
                 System.out.println(attrs.get("cn"));
             }
         } else {
             System.out.println(obj);
         }
         System.out.println();
     }
        
        boolean flag = PasswordHelper.verifySHA("{SSHA}pL0UiQNll/fhmNDD+peECuQ8kZkuEuBoUMcOIg==", "987654");
        System.out.println(flag);
        
        closeCtx();
    }
  
}