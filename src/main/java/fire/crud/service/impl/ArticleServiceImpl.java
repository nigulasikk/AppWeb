package fire.crud.service.impl;

import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import fire.crud.entity.Article;
import fire.crud.service.IArticleService;

@Service("articleService")
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements IArticleService {
	final Logger logger = LoggerFactory.getLogger(getClass());
	
	
}
