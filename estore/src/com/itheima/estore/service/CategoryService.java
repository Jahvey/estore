package com.itheima.estore.service;

import java.util.List;

import com.itheima.estore.dao.CategoryDao;
import com.itheima.estore.domain.Category;

/**
 * 分类模块业务层代码:
 * @author jiangtao
 *
 */
public class CategoryService {

	/**
	 * 业务层查询所有分类的方法
	 * @return
	 */
	public List<Category> findAll() {
		CategoryDao categoryDao = new CategoryDao();
		return categoryDao.findAll();
	}

	/**
	 * 业务层保存分类的方法:
	 * @param category
	 */
	public void save(Category category) {
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.save(category);
	}

	/**
	 * 业务层根据分类的ID查询分类的方法
	 * @param cid
	 * @return
	 */
	public Category findByCid(String cid) {
		CategoryDao categoryDao = new CategoryDao();
		return categoryDao.findByCid(cid);
	}

	/**
	 * 业务层修改分类的方法;
	 * @param category
	 */
	public void update(Category category) {
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.update(category);
	}

	/**
	 * 业务层的删除分类的方法
	 * @param cid
	 */
	public void delete(String cid) {
		CategoryDao categoryDao = new CategoryDao();
		categoryDao.delete(cid);
	}

}
