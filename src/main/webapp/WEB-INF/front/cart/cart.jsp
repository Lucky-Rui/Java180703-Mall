<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>
<!DOCTYPE html>
<html lang="zh-cmn-Hans">
<head>
	<meta charset="UTF-8">
	<link rel="shortcut icon" href="${ctx}/static/front/favicon.ico">
	<link rel="stylesheet" href="${ctx}/static/front/css/iconfont.css">
	<link rel="stylesheet" href="${ctx}/static/front/css/global.css">
	<link rel="stylesheet" href="${ctx}/static/front/css/bootstrap.min.css">
	<link rel="stylesheet" href="${ctx}/static/front/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="${ctx}/static/front/css/swiper.min.css">
	<link rel="stylesheet" href="${ctx}/static/front/css/styles.css">
	<link rel="stylesheet" href="${ctx}/static/front/css/login.css">
	
	<script src="${ctx}/static/front/js/jquery.1.12.4.min.js" charset="UTF-8"></script>
	<script src="${ctx}/static/front/js/jquery.DJMask.2.1.1.js" charset="UTF-8"></script>
	<script src="${ctx}/static/front/js/bootstrap.min.js" charset="UTF-8"></script>
	<script src="${ctx}/static/front/js/swiper.min.js" charset="UTF-8"></script>
	<script src="${ctx}/static/front/js/global.js" charset="UTF-8"></script>
	<script src="${ctx}/static/front/js/login.js" charset="UTF-8"></script>
	<script src="${ctx}/static/front/lib/layui/layui.js"></script>
	<script src="${ctx}/static/common/js/mylayer.js"></script>
	<script src="${ctx}/static/common/js/util.js"></script>
	<title>U袋网</title>
</head>
<body>
	<!-- 顶部tab -->
	<div class="tab-header">
		<div class="inner">
			<div class="pull-left">
				<div class="pull-left">嗨，欢迎来到<span class="cr">U袋网</span></div>
				<a href="${ctx}/static/front/agent_level.html">网店代销</a>
				<a href="${ctx}/static/front/temp_article/udai_article4.html">帮助中心</a>
			</div>
			<div class="pull-right">
				<a href="${ctx}/static/front/login.html"><span class="cr">登录</span></a>
				<a href="${ctx}/static/front/login.html?p=register">注册</a>
				<a href="${ctx}/static/front/udai_welcome.html">我的U袋</a>
				<a href="${ctx}/static/front/udai_order.html">我的订单</a>
				<a href="${ctx}/static/front/udai_integral.html">积分平台</a>
			</div>
		</div>
	</div>
	<!-- 顶部标题 -->
	<div class="bgf5 clearfix">
		<div class="top-user">
			<div class="inner">
				<a class="logo" href="${ctx}/static/front/index.html"><img src="${ctx}/static/front/images/icons/logo.jpg" alt="U袋网" class="cover"></a>
				<div class="title">购物车</div>
			</div>
		</div>
	</div>
	<div class="content clearfix bgf5">
		<section class="user-center inner clearfix">
			<div class="user-content__box clearfix bgf">
				<div class="title">购物车</div>
				<form class="shopcart-form__box">
					<table class="table table-bordered">
						<thead>
							<tr>
								<th width="150">
									<label class="checked-label">商品图片</label>
								</th>
								<th width="300">商品信息</th>
								<th width="150">单价</th>
								<th width="200">数量</th>
								<th width="200">总价</th>
								<th width="80">操作</th>
							</tr>
						</thead>
						<c:forEach items="${cartVO.cartItemVOList}" var="cartItemVO">
							<tbody>
								<tr>
									<th scope="row">
										<label class="checked-label">
										<c:if test="${cartItemVO.isChecked == 1}">
											<input type="checkbox" name="selectCheckbox" onclick="updateCartItemStatus(${cartItemVO.product.id})" id="checkbox${cartItemVO.product.id}" checked="checked" />
										</c:if>
										<c:if test="${cartItemVO.isChecked == 0}">
											<input type="checkbox" name="selectCheckbox" onclick="updateCartItemStatus(${cartItemVO.product.id})" id="checkbox${cartItemVO.product.id}" />
										</c:if>
											<i></i>
											<div class="img"><img src="/productImg/${cartItemVO.product.mainImage}" alt="" class="cover2"></div>
										</label>
									</th>
									<td>
										<div class="name ep3">${cartItemVO.product.name}</div>
									</td>
									<td id="price${cartItemVO.product.id}" price="${cartItemVO.product.price}" >
										¥ ${cartItemVO.product.price}
									</td>
									<td>
										<div class="cart-num__box">
											<input onclick="updateAmount(${cartItemVO.product.id}, ${cartItemVO.product.price}, -1)" class="sub" type="button" value="-" />
											<input id="num${cartItemVO.product.id}" value="${cartItemVO.amount}" class="val" type="text" placeholder="1" />
											<input onclick="updateAmount(${cartItemVO.product.id}, ${cartItemVO.product.price}, 1)" class="add" type="button" value="+" />
										</div>
									</td>
									<td id="cartItemTotalPrice${cartItemVO.product.id}"> 
										 ${cartItemVO.product.price * cartItemVO.amount}
									</td>
									<td><a onclick="deleteCartItemById(${cartItemVO.product.id})">删除</a></td>
								</tr>
							</tbody>
						</c:forEach>
					</table>
					<div class="user-form-group tags-box shopcart-submit pull-right">
						<a onclick="getOrderPage()" class="btn">提交订单</a>
					</div>
					<div class="checkbox shopcart-total">
						<label><input type="checkbox" class="check-all"><i></i> 全选</label>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a href="${ctx}/static/front/">删除</a>
						<div class="pull-right">
							已选商品 <span id="isChecked"></span> 件
							&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;合计（不含运费）
							<b class="cr">¥<span id="totalPrice" class="fz24"></span></b>
						</div>
					</div>
				</form>
			</div>
		</section>
	</div>
	<!-- 右侧菜单 -->
	<div class="right-nav">
		<ul class="r-with-gotop">
			<li class="r-toolbar-item">
				<a href="${ctx}/static/front/udai_welcome.html" class="r-item-hd">
					<i class="iconfont icon-user" data-badge="0"></i>
					<div class="r-tip__box"><span class="r-tip-text">用户中心</span></div>
				</a>
			</li>
			<li class="r-toolbar-item">
				<a href="${ctx}/static/front/udai_shopcart.html" class="r-item-hd">
					<i class="iconfont icon-cart"></i>
					<div class="r-tip__box"><span class="r-tip-text">购物车</span></div>
				</a>
			</li>
			<li class="r-toolbar-item">
				<a href="${ctx}/static/front/udai_collection.html" class="r-item-hd">
					<i class="iconfont icon-aixin"></i>
					<div class="r-tip__box"><span class="r-tip-text">我的收藏</span></div>
				</a>
			</li>
			<li class="r-toolbar-item">
				<a href="${ctx}/static/front/" class="r-item-hd">
					<i class="iconfont icon-liaotian"></i>
					<div class="r-tip__box"><span class="r-tip-text">联系客服</span></div>
				</a>
			</li>
			<li class="r-toolbar-item">
				<a href="${ctx}/static/front/issues.html" class="r-item-hd">
					<i class="iconfont icon-liuyan"></i>
					<div class="r-tip__box"><span class="r-tip-text">留言反馈</span></div>
				</a>
			</li>
			<li class="r-toolbar-item to-top">
				<i class="iconfont icon-top"></i>
				<div class="r-tip__box"><span class="r-tip-text">返回顶部</span></div>
			</li>
		</ul>
	</div>
	<!-- 底部信息 -->
	<div class="footer">
		<div class="footer-tags">
			<div class="tags-box inner">
				<div class="tag-div">
					<img src="${ctx}/static/front/images/icons/footer_1.gif" alt="厂家直供">
				</div>
				<div class="tag-div">
					<img src="${ctx}/static/front/images/icons/footer_2.gif" alt="一件代发">
				</div>
				<div class="tag-div">
					<img src="${ctx}/static/front/images/icons/footer_3.gif" alt="美工活动支持">
				</div>
				<div class="tag-div">
					<img src="${ctx}/static/front/images/icons/footer_4.gif" alt="信誉认证">
				</div>
			</div>
		</div>
		<div class="footer-links inner">
			<dl>
				<dt>U袋网</dt>
				<a href="${ctx}/static/front/temp_article/udai_article10.html"><dd>企业简介</dd></a>
				<a href="${ctx}/static/front/temp_article/udai_article11.html"><dd>加入U袋</dd></a>
				<a href="${ctx}/static/front/temp_article/udai_article12.html"><dd>隐私说明</dd></a>
			</dl>
			<dl>
				<dt>服务中心</dt>
				<a href="${ctx}/static/front/temp_article/udai_article1.html"><dd>售后服务</dd></a>
				<a href="${ctx}/static/front/temp_article/udai_article2.html"><dd>配送服务</dd></a>
				<a href="${ctx}/static/front/temp_article/udai_article3.html"><dd>用户协议</dd></a>
				<a href="${ctx}/static/front/temp_article/udai_article4.html"><dd>常见问题</dd></a>
			</dl>
			<dl>
				<dt>新手上路</dt>
				<a href="${ctx}/static/front/temp_article/udai_article5.html"><dd>如何成为代理商</dd></a>
				<a href="${ctx}/static/front/temp_article/udai_article6.html"><dd>代销商上架教程</dd></a>
				<a href="${ctx}/static/front/temp_article/udai_article7.html"><dd>分销商常见问题</dd></a>
				<a href="${ctx}/static/front/temp_article/udai_article8.html"><dd>付款账户</dd></a>
			</dl>
		</div>
		<div class="copy-box clearfix">
			<ul class="copy-links">
				<a href="${ctx}/static/front/agent_level.html"><li>网店代销</li></a>
				<a href="${ctx}/static/front/class_room.html"><li>U袋学堂</li></a>
				<a href="${ctx}/static/front/udai_about.html"><li>联系我们</li></a>
				<a href="${ctx}/static/front/temp_article/udai_article10.html"><li>企业简介</li></a>
				<a href="${ctx}/static/front/temp_article/udai_article5.html"><li>新手上路</li></a>
			</ul>
			<!-- 版权 -->
			<p class="copyright">
				© 2005-2017 U袋网 版权所有，并保留所有权利<br>
				ICP备案证书号：闽ICP备16015525号-2&nbsp;&nbsp;&nbsp;&nbsp;福建省宁德市福鼎市南下村小区（锦昌阁）1栋1梯602室&nbsp;&nbsp;&nbsp;&nbsp;Tel: 18650406668&nbsp;&nbsp;&nbsp;&nbsp;E-mail: 18650406668@qq.com
			</p>
		</div>
	</div>
	
	<!-- login弹出层 -->
	<div  class="form-box login" style="display:none;" id="loginForm">
		<div class="tabs-nav">
			<h2>欢迎登录U袋网平台</h2>
		</div>
		<div class="tabs_container">
			<form class="tabs_form" action="" method="post" id="login-form">
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-phone" aria-hidden="true"></span>
						</div>
						<input class="form-control phone" name="username" id="username" required placeholder="账号" autocomplete="off" type="text">
					</div>
				</div>
				<div class="form-group">
					<div class="input-group">
						<div class="input-group-addon">
							<span class="glyphicon glyphicon-lock" aria-hidden="true"></span>
						</div>
						<input class="form-control password" name="password" id="password" placeholder="请输入密码" autocomplete="off" type="password">
						<div class="input-group-addon pwd-toggle" title="显示密码"><span class="glyphicon glyphicon-eye-open" aria-hidden="true"></span></div>
					</div>
				</div>
				<div class="checkbox">
                    <label>
                    	<input checked="" id="login_checkbox" type="checkbox"><i></i> 30天内免登录
                    </label>
                    <a href="javascript:;" class="pull-right" id="resetpwd">忘记密码？</a>
                </div>
                <!-- 错误信息 -->
				<div class="form-group">
					<div class="error_msg" id="login_error">
						<!-- 错误信息 范例html
						<div class="alert alert-warning alert-dismissible fade in" role="alert">
							<button type="button" class="close" data-dismiss="alert" aria-label="Close"><span aria-hidden="true">&times;</span></button>
							<strong>密码错误</strong> 请重新输入密码
						</div>
						 -->
					</div>
				</div>
                    <button class="btn btn-large btn-primary btn-lg btn-block submit"  onclick="login()" id="login_submit" type="button">
                    	登录
                    </button><br/>
                    <p class="text-center">没有账号？<a href="javascript:;" id="register">免费注册</a></p>
            </form>
            <div class="tabs_div">
            	<div class="success-box">
             		<div class="success-msg">
						<i class="success-icon"></i>
             			<p class="success-text">登录成功</p>
             		</div>
             	</div>
             	<div class="option-box">
             		<div class="buts-title">
             			现在您可以
             		</div>
             		<div class="buts-box">
             			<a role="button" href="index.html" class="btn btn-block btn-lg btn-default">继续访问商城</a>
						<a role="button" href="udai_welcome.html" class="btn btn-block btn-lg btn-info">登录会员中心</a>
             	    </div>
             	</div>
            </div>
		</div>
	</div>
	
	<script>
		//返回顶部
		$(document).ready(function(){ $('.to-top').toTop({position:false}) });
	</script>
	<script type="text/javascript">
		layui.use(['layer'], function(){
	       var layer = layui.layer;
	    });
	
		$(function() {
			// 页面加载完之后计算一下总价格，显示在页面上
			refreshTotalPrice();
			refreshIsChecked();
		});
			
		// 更新购物车中商品的数量
		function updateAmount(productId, price, num) {
			var amount = $("#num" + productId).val();
			$.ajax({
				url : "${ctx}/cart/addOrUpdateCart.shtml",
				data : {"productId" : productId, "amount" : num, "isChecked" : 1},
				type: "POST",
				dataType : "json",
				success : function(resp){
					if (resp.code == util.SUCCESS) {
						mylayer.success(resp.msg);
						amount = parseInt(amount) + num;
						$("#num" + productId).val(amount);
						var totalPrice = amount * price;
						$("#cartItemTotalPrice" + productId).html(totalPrice);
						// TODO:让这个checkbox选中状态
						refreshTotalPrice();
					} else {
						mylayer.errorMsg(resp.msg);
					}
				}
			});
		}
	
		// 根据productId删除购物车中的购物项CartItemVO
		function deleteCartItemById(productId) {
			layer.confirm("您确认要删除么？", function() {
				$.ajax({
					url : "${ctx}/cart/deleteCartItemById.shtml",
					data : {"productId" : productId},
					type: "POST",
					dataType : "json",
					success : function(resp){
						if (resp.code == util.SUCCESS) {
							mylayer.success(resp.msg);
							$("#checkbox" + productId).parent().parent().parent().remove();
						} else {
							mylayer.errorMsg(resp.msg);
						}
					}
				});
			})
		}
		
		//更新已选商品
		function refreshIsChecked(){
			var num = 0;
			var checks = $("input[name=selectCheckbox]:checked");
			for(i=0;i<checks.length;i++){
		        if(checks[i].checked)
		        	num++;
		    }
			$("#isChecked").html(num);
		}
		
		// 选择或者取消商品在购物城中状态，点击checkbox
		function updateCartItemStatus(productId) {
			var isChecked = $("#checkbox" + productId).prop("checked");
			if(isChecked) {
				isChecked = 1;
			} else {
				isChecked = 0;
			}
			$.ajax({
				url : "${ctx}/cart/addOrUpdateCart.shtml",
				data : {"productId" : productId, "isChecked" : isChecked},
				type: "POST",
				dataType : "json",
				success : function(resp){
					if (resp.code == util.SUCCESS) {
						mylayer.success(resp.msg);
						//刷新一下总价格
						refreshTotalPrice();
						//刷新已选的商品个数
						refreshIsChecked();
					} else {
						mylayer.errorMsg(resp.msg);
					}
				}
			});
		}
		
		// 更新购物车总价格
		function refreshTotalPrice() {
			var checkboxs = $("input[name=selectCheckbox]:checked");
			var totalPrice = 0.00;
			for(var i = 0; i < checkboxs.length; i++) {
				// checkbox属性： id="checkbox278"
				// checkbox278
				var checkboxId = checkboxs[i].getAttribute("id");
				// 278
				var id = checkboxId.substr("checkbox".length);
				//得到每一个CartItemVO的总价
				// "123.00" 得到的是字符串类型的数据
				var cartItemTotalPrice = $("#cartItemTotalPrice" + id).html();
				totalPrice += parseFloat(cartItemTotalPrice);
			}
			$("#totalPrice").html(totalPrice);
		}
		
		// ---------------------------------------------------------	
		//跳转到结算页面
		function getOrderPage() {
			//todo:用户没有勾选任何商品checkbox，给用户一个提示：您还没有选择任何商品
			// Session也是一个域对象，${USER}从request域对象找不到从Session域对象找
			var user = "${USER}";
			if(user == "") {//这个用户没有登录了，从Session里面拿到
				layer.open({
					type : 1,
					title : "登录",
					offset : "50px",
					area : ["525px",'450px'],
					content : $('#loginForm')
				});
			} else {//这个用户已经登录，直接跳转到生成订单页面
				window.location.href = '${ctx}/order/getOrderPage.shtml';
			}
		}
		
		function login() {
			/*
			1、验证用户名
			1.1、验证用户名是否为空
			1.2、是否合法：4-8数字或字母
			2、密码不能为空
			3、ajax提交用户名和密码，并且接受后台返回的json数据
			*/
			var username = $("#username").val();
			var password = $("#password").val();
			//1.1、验证用户名是否为空
			if(util.isNull(username)) {
				mylayer.errorMsg("用户名不能为空");
				return;
			}
			
			//1.2、是否合法：4-8数字或字母
			if(!isUsernameValid(username)) {
				mylayer.errorMsg("用户名不合法，4-8数字或字母");
				return;
			}
			
			//2、密码不能为空
			if(util.isNull(password)) {
				mylayer.errorMsg("密码不能为空");
				return;
			}
			
			//3、ajax提交用户名和密码，并且接受后台返回的json数据
			$.ajax({
				url : "${ctx}/user/login.shtml",
				type : "POST",
				dataType : "json",
				data : $("#login-form").serialize(),
				success : function(data) {
					if(data.code == util.SUCCESS) {
						mylayer.success(data.msg);
						//mylayer.successUrl(data.msg, "${ctx}/index.action");
						window.location.href = '${ctx}/order/getOrderPage.shtml';
					} else {
						mylayer.errorMsg(data.msg);
					}
				}
			});
		}
		
		/*是否合法：4-8数字或字母*/
		function isUsernameValid(value) {
			var pattern = /^[0-9a-zA-Z]{4,8}$/;
			return pattern.test(value);
		} 
	</script>
</body>
</html>