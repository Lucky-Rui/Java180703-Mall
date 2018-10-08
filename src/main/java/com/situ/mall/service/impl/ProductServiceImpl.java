package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Product;
import com.situ.mall.mapper.ProductMapper;
import com.situ.mall.service.IProductService;

@Service
public class ProductServiceImpl implements IProductService {

	@Autowired
	private ProductMapper productMapper;

	@Override
	public List<Product> list() {
		return productMapper.list();
	}

	@Override
	public ServerResponse<List<Product>> pageList(Integer page, Integer limit, Product product) {
		// 1、设置分页
		PageHelper.startPage(page, limit);
		// 2、执行查询 （分页之后的数据）
		List<Product> list = productMapper.pageList(product);
		// 3、count
		// 第一种：分页时，实际返回的结果list类型是Page<E>，如果想取出分页信息，需要强制转换为Page<E>
		// Integer count = (int) ((Page) list).getTotal();
		// 第二种：用PageInfo对结果进行包装
		PageInfo<Product> pageInfo = new PageInfo<Product>(list);
		Integer count = (int) pageInfo.getTotal();
		return ServerResponse.createSuccess("查询成功", count, list);

	}

	@Override
	public ServerResponse<List<Product>> deleteByPrimaryKey(Integer id) {
		try {
			int count = productMapper.deleteByPrimaryKey(id);
			if (count == 1) {
				return ServerResponse.createSuccess("删除成功");
			} else {
				return ServerResponse.createError("删除失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除失败");
		}
	}

	@Override
	public ServerResponse<List<Product>> deleteAll(String ids) {
		String[] idArray = ids.split(",");
		int count = productMapper.deleteAll(idArray);
		if (count == idArray.length) {
			return ServerResponse.createSuccess("删除成功");
		} else {
			return ServerResponse.createError("删除失败");
		}
	}

	@Override
	public ServerResponse<List<Product>> insertProduct(Product product) {
		try {
			int count = productMapper.insert(product);
			if (count == 1) {
				return ServerResponse.createSuccess("添加成功");
			} else {
				return ServerResponse.createError("添加失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("添加失败");
		}
	}

	@Override
	public ServerResponse<List<Product>> updateByPrimaryKey(Product product) {
		try {
			int count = productMapper.updateByPrimaryKey(product);
			if (count == 1) {
				return ServerResponse.createSuccess("更新成功");
			} else {
				return ServerResponse.createError("更新失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("更新失败");
		}
	}

	@Override
	public Product selectByPrimaryKey(Integer id) {
		return productMapper.selectByPrimaryKey(id);
	}

	
}
