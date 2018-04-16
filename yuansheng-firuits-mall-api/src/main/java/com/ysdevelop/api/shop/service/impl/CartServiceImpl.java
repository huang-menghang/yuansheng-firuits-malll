package com.ysdevelop.api.shop.service.impl;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ysdevelop.api.entity.Cart;
import com.ysdevelop.api.entity.CartItem;
import com.ysdevelop.api.entity.Member;
import com.ysdevelop.api.shop.mapper.CartDao;
import com.ysdevelop.api.shop.service.CartItemService;
import com.ysdevelop.api.shop.service.CartService;
import com.ysdevelop.common.exception.WebServiceException;
import com.ysdevelop.common.result.CodeMsg;
import com.ysdevelop.common.utils.Constant;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	private CartDao cartDao;
	
	@Autowired
	private CartItemService cartItemService;

	@Override
	public void save(Member member,HttpSession session) {
		if (member == null) {
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Cart memberCart = cartDao.getByMemberId(member.getId());
		if (memberCart == null) {
			memberCart = new Cart();
			memberCart.setMemberId(member.getId());
			cartDao.save(memberCart);
			member.setCartId(memberCart.getId());
		} else {
            member.setCartId(memberCart.getId());
		}
		session.setAttribute(Constant.TOKEN_NAME, member);
	}

	@Override
	public Cart getById(Long id) {
		if(id==null){
			throw new WebServiceException(CodeMsg.SERVER_ERROR);
		}
		Cart cart=new Cart();
		List<CartItem> cartItems = cartItemService.listByCartId(id);
		cart.setCartItems(cartItems);
		return cart;
	}

}
