

import java.io.File;
import java.util.LinkedList;
import java.util.Queue;

public class ListFile4Log {
	
	public static void main(String[] args) {
		File root = new File("src/main/java");
		if(!root.exists()||!root.isDirectory()){
			System.out.println("目录不对");
		}
		
		Queue<File> filequeue=new LinkedList<File>();
		
		filequeue.add(root);
		
		while(filequeue.size()>0){
		
			File cur = filequeue.poll();
			for(File f:cur.listFiles()){
				if(f.isDirectory()){
					filequeue.add(f);
				}else{
					if(f.getName().endsWith(".java")){
						String s = f.getAbsolutePath();
						s=s.substring(s.indexOf(root.getName())+root.getName().length()+1);
						s=s.substring(0,s.length()-5);
						s=s.replace('\\', '.');
						System.out.printf("log4j.logger.%s=debug\n",s);
					}
				}
			}
		}
	}

}
