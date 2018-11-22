package com.situ.mall.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.situ.mall.common.ServerResponse;
import com.situ.mall.entity.Cart;
import com.situ.mall.mapper.CartMapper;
import com.situ.mall.service.ICartService;

@Service
public class CartServiceImpl implements ICartService {
	@Autowired
	private CartMapper cartMapper;

	@Override
	public ServerResponse pageList(Integer page, Integer limit, Cart cart) {
		System.out.println("cart:" + cart);
		PageHelper.startPage(page, limit);
		List<Cart> list = cartMapper.pageList(cart);
		PageInfo pageInfo = new PageInfo(list);
		Integer count = (int) pageInfo.getTotal();

		return ServerResponse.createSuccess("查询成功", count, list);

	}

	@Override
	public ServerResponse deleteById(Integer id) {
		try {
			int count = cartMapper.deleteByPrimaryKey(id);
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
	public ServerResponse deleteAll(String ids) {
		String[] idArray = ids.split(",");
		try {
			int count = cartMapper.deleteAll(idArray);
			if (count == idArray.length) {
				return ServerResponse.createSuccess("删除成功");
			} else {
				return ServerResponse.createError("删除失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("删除失败");
		}
	}

	@Override
	public ServerResponse add(Cart cart) {
		try {
			int count = cartMapper.insert(cart);
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
	public Cart selectByProductId(Integer productId) {
		Cart cart = cartMapper.selectByProductId(productId);

		return cart;
	}

	@Override
	public List<Cart> selectByUserId(Integer userId) {
		List<Cart> cartList = cartMapper.selectByUserId(userId);
		return cartList;
	}

	@Override
	public ServerResponse update(Cart cart) {
		try {
			int count = cartMapper.updateByPrimaryKey(cart);
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
	public ServerResponse updateByProductId(Cart cart) {
		try {
			int count = cartMapper.updateByProductId(cart);
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
	public ServerResponse deleteByProductId(Integer productId) {
		try {
			int count = cartMapper.deleteByProductId(productId);
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
	public ServerResponse updateChecked(Integer checked) {
		System.out.println("checked:" + checked);
		try {
			int count = cartMapper.updateChecked(checked);
			if (count == 1) {
				return ServerResponse.createSuccess("更新成功");
			} else {
				return ServerResponse.createError("更新失败");
			}
		} catch (Exception e) {
			return ServerResponse.createError("更新失败");
		}
	}

}
