<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<title>商品列表</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width,user-scalable=yes, minimum-scale=0.4, initial-scale=0.8,target-densitydpi=low-dpi" />
    
    <link rel="shortcut icon" href="/favicon.ico" type="image/x-icon" />
    <link rel="stylesheet" href="${ctx}/static/back/lib/layui/css/layui.css" media="all">
    <link rel="stylesheet" href="${ctx}/static/back/css/font.css">
	<link rel="stylesheet" href="${ctx}/static/back/css/xadmin.css">
	
	<script src="${ctx}/static/back/lib/jquery/jquery-3.2.1.min.js"></script>
	<script src="${ctx}/static/back/lib/layui/layui.js"></script>
    <script src="${ctx}/static/back/js/xadmin.js"></script>
    <script src="${ctx}/static/common/js/util.js"></script>
    <script src="${ctx}/static/common/js/mylayer.js"></script>
</head>
<body>
    <div class="x-nav">
      <span class="layui-breadcrumb">
        <a href="">首页</a>
        <a >订单管理</a>
        <a>
          <cite>订单列表</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon layui-icon-refresh"></i></a>
    </div>
    <div class="x-body">
	    <div class="demoTable layui-row x-so">
	      <div class="layui-inline">
	          <input type="text" id="searchOrderNo"  placeholder="请输入订单号" autocomplete="off" class="layui-input">
		  </div>          
		  <div class="layui-inline">
	          <input type="text" id="searchUserId"  placeholder="请输入用户的ID" autocomplete="off" class="layui-input">
	      </div> 
	          <button class="layui-btn" data-type="search"><i class="layui-icon">&#xe615;</i>搜索订单</button>
	          <button class="layui-btn layui-btn-danger" data-type="deleteAll"><i class="layui-icon"></i>批量删除</button>
	          <button class="layui-btn" onclick="x_admin_show('添加订单','./member-add.html',600,400)"><i class="layui-icon"></i>添加订单</button>
	    </div>
		<table id="tableId" lay-filter="tableFilter"></table>
    </div>
    
 	<script type="text/html" id="barDemo">
       <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
       <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
       <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
	<script>
		layui.use('table', function(){
		  var table = layui.table;
		  
		  table.render({
		    elem: '#tableId'
		    ,id : "layUITableId" //设定容器唯一ID，id值是对表格的数据操作方法上是必要的传递条件，它是表格容器的索引
		   	,page : true
		    ,url: '${ctx}/order/pageList.action' //数据接口
		    ,cols: [[ //表头
		       {type:'checkbox', fixed: 'left'}
		      ,{field: 'id', title: '订单ID', sort: true, fixed: 'left'}
		      ,{field: 'orderNo', title: '订单号',  sort: true}
		      ,{field: 'userId', title: '用户ID'}
		      ,{field: 'shippingId', title: 'shippingId'}
		      ,{field: 'payment', title: '实际付款金额(元)'} 
		      ,{field: 'paymentType', title: '支付类型'}
		      ,{field: 'postage', title: '运费'}
		      ,{field: 'status', title: '订单状态',  sort: true}
		      ,{field: 'paymentTime', title: '支付时间', sort: true}
		      ,{field: 'sendTime', title: '发货时间',  sort: true}
		      ,{field: 'endTime', title: '交易完成时间',  sort: true}
		      ,{field: 'closeTime', title: '交易关闭时间',  sort: true}
		      ,{field: 'createTime', title: '创建时间',  sort: true}
		      ,{field: 'updateTime', title: '更新时间', sort: true}
		      ,{fixed: 'right', width:178, align:'center', toolbar: '#barDemo'}
		    ]]
		  });
		});
	</script>
	<script>
		layui.use('table', function(){
		  var table = layui.table;
		  
		  //监听工具条
		  //tool是工具条事件名，tableFilter是table容器属性lay-filter="tableFilter"对应的值
		  table.on('tool(tableFilter)', function(obj){
		    var data = obj.data;//获取当前行对象数据，json格式
		    if(obj.event === 'detail'){
		      layer.msg('ID：'+ data.id + ' 的查看操作');
		    } else if(obj.event === 'del'){
		      layer.confirm('确定删除这个订单吗?', function(index){
		    	  $.ajax({
		    		url:"${ctx}/order/deleteByPrimaryKey.action",
		    		data:{"id":data.id},
		    		dataType:"json",
		    		success:function(resp) {
		    			if(resp.code == util.SUCCESS){
		    				mylayer.success(resp.msg);
		    				table.reload("layUITableId");//表格重新加载
		    			} else {
		    				mylayer.errorMsg(resp.msg);
		    			}
			        layer.close(index);
		    		}
		    	  });
		      });
		    } else if(obj.event === 'edit'){
		      layer.alert('编辑行：<br>'+ JSON.stringify(data))
		    }
		  });
		  
		  var $ = layui.$, active = {
			//批量删除
		    deleteAll: function(){ 
		       //获取选中数据
		       var checkStatus = table.checkStatus('layUITableId');
		       var data = checkStatus.data;
		       console.log(data);//选中行的数据
		       console.log(checkStatus.data.length);//获取选中行的数量
		       console.log(checkStatus.isAll);//表格是否全选
		       var ids = util.getSelectedIds(data);
		       console.log(ids);
		       layer.confirm('确定删除这些订单吗?', function(index){
			    	$.ajax({
			    		url:"${ctx}/order/deleteAll.action",
			    		data:{"ids":ids},
			    		dataType:"json",
			    		success:function(resp) {
			    			if(resp.code == util.SUCCESS){
			    				mylayer.success(resp.msg);
			    				table.reload("layUITableId");
			    			} else {
			    				mylayer.errorMsg(resp.msg);
			    			}
				        layer.close(index);
			    		}
			    	});
			   });
		    },
		    //搜索
			search : function() {
				table.reload('layUITableId', {
				  where: { //设定异步数据接口的额外参数，任意设
					  orderNo:$("#searchOrderNo").val(),
					  userId:$("#searchUserId").val()
				  }
				  ,page: {
				    curr: 1 //重新从第 1 页开始
				  }
				});
			}		    
		  };		  
		  
		  $('.demoTable .layui-btn').on('click', function(){
		    var type = $(this).data('type');
		    active[type] ? active[type].call(this) : '';
		  });
		});
	</script>
</body>
</html>