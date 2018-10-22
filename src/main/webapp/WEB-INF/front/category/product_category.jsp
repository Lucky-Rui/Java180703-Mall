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
	
	<script src="${ctx}/static/front/js/jquery.1.12.4.min.js" charset="UTF-8"></script>
	<script src="${ctx}/static/front/js/bootstrap.min.js" charset="UTF-8"></script>
	<script src="${ctx}/static/front/js/swiper.min.js" charset="UTF-8"></script>
	<script src="${ctx}/static/front/js/global.js" charset="UTF-8"></script>
	<script src="${ctx}/static/front/js/jquery.DJMask.2.1.1.js" charset="UTF-8"></script>
	<script src="${ctx}/static/front/lib/layui/layui.js" charset="UTF-8"></script>
	<script src="${ctx}/static/common/js/mylayer.js" charset="UTF-8"></script>
	<script src="${ctx}/static/common/js/util.js" charset="UTF-8"></script>
	<script src="${ctx}/static/front/js/jquery.magnifier.js"></script>
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
	<!-- 搜索栏 -->
	<div class="top-search">
		<div class="inner">
			<a class="logo" href="${ctx}/static/front/index.html"><img src="${ctx}/static/front/images/icons/logo.jpg" alt="U袋网" class="cover"></a>
			<div class="search-box">
				<form class="input-group">
					<input placeholder="Ta们都在搜U袋网" type="text">
					<span class="input-group-btn">
						<button type="button">
							<span class="glyphicon glyphicon-search" aria-hidden="true"></span>
						</button>
					</span>
				</form>
				<p class="help-block text-nowrap">
					<a href="${ctx}/static/front/">连衣裙</a>
					<a href="${ctx}/static/front/">裤</a>
					<a href="${ctx}/static/front/">衬衫</a>
					<a href="${ctx}/static/front/">T恤</a>
					<a href="${ctx}/static/front/">女包</a>
					<a href="${ctx}/static/front/">家居服</a>
					<a href="${ctx}/static/front/">2017新款</a>
				</p>
			</div>
			<div class="cart-box">
				<a href="${ctx}/static/front/udai_shopcart.html" class="cart-but">
					<i class="iconfont icon-shopcart cr fz16"></i> 购物车 0 件
				</a>
			</div>
		</div>
	</div>
	<!-- 内页导航栏 -->
	<div class="top-nav bg3">
		<div class="nav-box inner">
			<div class="all-cat">
				<div class="title"><i class="iconfont icon-menu"></i> 全部分类</div>
			</div>
			<ul class="nva-list">
				<a href="${ctx}/static/front/index.html"><li>首页</li></a>
				<a href="${ctx}/static/front/temp_article/udai_article10.html"><li>企业简介</li></a>
				<a href="${ctx}/static/front/temp_article/udai_article5.html"><li>新手上路</li></a>
				<a href="${ctx}/static/front/class_room.html"><li>U袋学堂</li></a>
				<a href="${ctx}/static/front/enterprise_id.html"><li>企业账号</li></a>
				<a href="${ctx}/static/front/udai_contract.html"><li>诚信合约</li></a>
				<a href="${ctx}/static/front/item_remove.html"><li>实时下架</li></a>
			</ul>
		</div>
	</div>
	<div class="content inner">
		<section class="filter-section clearfix">
			<ol class="breadcrumb">
				<li><a href="${ctx}/static/front/index.html">首页</a></li>
				<li class="active">商品筛选</li>
			</ol>
			<div class="filter-box">
				<div class="all-filter">
					<div class="filter-value">
						<div class="filter-title">选择商品分类 <i class="iconfont icon-down"></i></div>
						<!-- 全部大分类 -->
						<ul class="catelist-card">
							<a href="${ctx}/static/front/"><li class="active">全部分类</li></a>
							<a href="${ctx}/static/front/"><li>女装</li></a>
							<a href="${ctx}/static/front/"><li>男装</li></a>
							<a href="${ctx}/static/front/"><li>包包</li></a>
							<a href="${ctx}/static/front/"><li>童装</li></a>
							<a href="${ctx}/static/front/"><li>鞋靴</li></a>
						</ul>
						<!-- 已选选项 -->
						<div class="ul_filter">
							<span class="pull-left">
								颜色：红色 <a href="${ctx}/static/front/javascript:;" class="close">&times;</a>
							</span>
							<span class="pull-left">
								尺寸：XXL <a href="${ctx}/static/front/javascript:;" class="close">&times;</a>
							</span>
						</div>
						<a class="reset pull-right" href="${ctx}/static/front/item_category.html">重置</a>
					</div>
				</div>
				<div class="filter-prop-item">
					<span class="filter-prop-title">分类：</span>
					<ul class="clearfix">
						<a href="${ctx}/static/front/"><li class="active">全部</li></a>
						<a href="${ctx}/static/front/"><li>上装</li></a>
						<a href="${ctx}/static/front/"><li>下装</li></a>
						<a href="${ctx}/static/front/"><li>裙装</li></a>
						<a href="${ctx}/static/front/"><li>内衣</li></a>
					</ul>
				</div>
				<div class="filter-prop-item">
					<span class="filter-prop-title">颜色：</span>
					<ul class="clearfix">
						<a href="${ctx}/static/front/"><li class="active">全部</li></a>
						<a href="${ctx}/static/front/"><li>红色</li></a>
						<a href="${ctx}/static/front/"><li>粉红</li></a>
						<a href="${ctx}/static/front/"><li>蓝色</li></a>
						<a href="${ctx}/static/front/"><li>白色</li></a>
					</ul>
				</div>
				<div class="filter-prop-item">
					<span class="filter-prop-title">尺寸：</span>
					<ul class="clearfix">
						<a href="${ctx}/static/front/"><li class="active">全部</li></a>
						<a href="${ctx}/static/front/"><li>L</li></a>
						<a href="${ctx}/static/front/"><li>M</li></a>
						<a href="${ctx}/static/front/"><li>S</li></a>
						<a href="${ctx}/static/front/"><li>X</li></a>
						<a href="${ctx}/static/front/"><li>XL</li></a>
						<a href="${ctx}/static/front/"><li>XXL</li></a>
						<a href="${ctx}/static/front/"><li>XXXL</li></a>
					</ul>
				</div>
				<div class="filter-prop-item">
					<span class="filter-prop-title">价格：</span>
					<ul class="clearfix">
						<a href="${ctx}/static/front/"><li class="active">全部</li></a>
						<a href="${ctx}/static/front/"><li>0-20</li></a>
						<a href="${ctx}/static/front/"><li>20-40</li></a>
						<a href="${ctx}/static/front/"><li>40-80</li></a>
						<a href="${ctx}/static/front/"><li>80-100</li></a>
						<a href="${ctx}/static/front/"><li>100-150</li></a>
						<a href="${ctx}/static/front/"><li>150以上</li></a>
						<form class="price-order">
							<input type="text">
							<span class="cc">-</span>
							<input type="text">
							<input type="button" value="确定">
						</form>
					</ul>
				</div>
			</div>
			<div class="sort-box bgf5">
				<div class="sort-text">排序：</div>
				<a href="${ctx}/static/front/"><div class="sort-text">销量 <i class="iconfont icon-sortDown"></i></div></a>
				<a href="${ctx}/static/front/"><div class="sort-text">评价 <i class="iconfont icon-sortUp"></i></div></a>
				<a href="${ctx}/static/front/"><div class="sort-text">价格 <i class="iconfont"></i></div></a>
				<div class="sort-total pull-right">共1688个商品</div>
			</div>
		</section>
		<section class="item-show__div clearfix">
			<div class="pull-left">
				<div class="item-list__area clearfix">
					<c:forEach items="${productList}" var="productList">
						<div class="item-card">
							<a href="${ctx}/product/getProductDetailPage.shtml?productId=${productList.id}" class="photo">
								<img src="/productImg/${productList.mainImage}" class="cover">
								<div class="name">${productList.name}</div>
							</a>
							<div class="middle">
								<div class="price"><small>￥</small>${productList.price}</div>
								<div class="sale"><a onclick="addCart()">加入购物车</a></div>
							</div>
							<div class="buttom">
								<div>销量 <b>666</b></div>
								<div>人气 <b>888</b></div>
								<div>评论 <b>1688</b></div>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
			<div class="pull-right">
				
				<div class="desc-segments__content">
					<div class="lace-title">
						<span class="c6">爆款推荐</span>
					</div>
					<div class="picked-box">
						<a href="${ctx}/static/front/" class="picked-item"><img src="${ctx}/static/front/images/temp/S-001.jpg" alt="" class="cover"><span class="look_price">¥134.99</span></a>
						<a href="${ctx}/static/front/" class="picked-item"><img src="${ctx}/static/front/images/temp/S-002.jpg" alt="" class="cover"><span class="look_price">¥134.99</span></a>
						<a href="${ctx}/static/front/" class="picked-item"><img src="${ctx}/static/front/images/temp/S-003.jpg" alt="" class="cover"><span class="look_price">¥134.99</span></a>
						<a href="${ctx}/static/front/" class="picked-item"><img src="${ctx}/static/front/images/temp/S-004.jpg" alt="" class="cover"><span class="look_price">¥134.99</span></a>
						<a href="${ctx}/static/front/" class="picked-item"><img src="${ctx}/static/front/images/temp/S-005.jpg" alt="" class="cover"><span class="look_price">¥134.99</span></a>
						<a href="${ctx}/static/front/" class="picked-item"><img src="${ctx}/static/front/images/temp/S-006.jpg" alt="" class="cover"><span class="look_price">¥134.99</span></a>
						<a href="${ctx}/static/front/" class="picked-item"><img src="${ctx}/static/front/images/temp/S-007.jpg" alt="" class="cover"><span class="look_price">¥134.99</span></a>
						<a href="${ctx}/static/front/" class="picked-item"><img src="${ctx}/static/front/images/temp/S-008.jpg" alt="" class="cover"><span class="look_price">¥134.99</span></a>
						<a href="${ctx}/static/front/" class="picked-item"><img src="${ctx}/static/front/images/temp/S-009.jpg" alt="" class="cover"><span class="look_price">¥134.99</span></a>
						<a href="${ctx}/static/front/" class="picked-item"><img src="${ctx}/static/front/images/temp/S-010.jpg" alt="" class="cover"><span class="look_price">¥134.99</span></a>
					</div>
				</div>
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
		<script>
			$(document).ready(function(){ $('.to-top').toTop({position:false}) });
		</script>
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
	
	<script type="text/javascript">
		//加入购物车
		layui.use(['layer'], function(){
			var layer = layui.layer;
		});
	
		function addCart() {
			//window.location.href = 
			//	"${ctx}/cart/getCartPage.shtml?productId=${product.id}&amount="+$("#amount").val()+"&isChecked=1";
			$.ajax({
				url : "${ctx}/cart/addOrUpdateCart.shtml",
				data : {"productId" : "${product.id}", "amount" : $("#amount").val()},
				type : "POST",
				dataType : "json",
				success : function(resp) {
					if (resp.code == util.SUCCESS) {
						layer.msg(resp.msg);
						mylayer.successUrl(resp.msg, "${ctx}/cart/getCartPage.shtml");
					} else {
						mylayer.errorMsg(resp.msg);
					}
				}
			});
		}
	</script>
</body>
</html>