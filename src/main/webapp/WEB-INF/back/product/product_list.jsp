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
        <a >商品管理</a>
        <a>
          <cite>商品列表</cite></a>
      </span>
      <a class="layui-btn layui-btn-small" style="margin-top:3px;float:right" href="javascript:location.replace(location.href);" title="刷新">
        <i class="layui-icon layui-icon-refresh"></i></a>
    </div>
    <div class="x-body">
	    <div class="demoTable layui-row x-so">
	      <div class="layui-inline">
	          <input type="text" id="searchId"  placeholder="请输入商品的ID" autocomplete="off" class="layui-input">
		  </div>          
		  <div class="layui-inline">
	          <input type="text" id="searchName"  placeholder="请输入商品的名称" autocomplete="off" class="layui-input">
	      </div> 
	          <button class="layui-btn" data-type="search"><i class="layui-icon">&#xe615;</i>搜索商品</button>
	          <button class="layui-btn layui-btn-danger" data-type="deleteAll"><i class="layui-icon"></i>批量删除</button>
	          <button class="layui-btn" onclick="x_admin_show('添加商品','${ctx}/product/getProductInsertPage.action',700,550)"><i class="layui-icon"></i>添加商品</button>
	    </div>
		<table id="tableId" lay-filter="tableFilter"></table>
    </div>
    
 	<script type="text/html" id="barDemo">
       <a class="layui-btn layui-btn-primary layui-btn-xs" lay-event="detail">查看</a>
       <a class="layui-btn layui-btn-xs" lay-event="update">更新</a>
       <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
	</script>
		<script type="text/html" id="statusTpl">
		 {{#  if(d.status == 1){  }}
		 	           上架
		 {{#  } else {            }}
				  下架
		 {{#  }					  }}
	</script>
	<script type="text/html" id="mainImageTpl">
		 <img src="/productImg/{{d.mainImage}}"/>
	</script>
	<script>
		layui.use('table', function(){
		  var table = layui.table;
		  
		  table.render({
		    elem: '#tableId'
		    ,id : "layUITableId" //设定容器唯一ID，id值是对表格的数据操作方法上是必要的传递条件，它是表格容器的索引
		   	,page : true
		    ,url: '${ctx}/product/pageList.action' //数据接口
		    ,cols: [[ //表头
		       {type:'checkbox', fixed: 'left'}
		      ,{field: 'id', title: '商品ID', sort: true, fixed: 'left'}
		      ,{field: 'categoryId', title: '分类ID',  sort: true}
		      ,{field: 'name', title: '商品名称'}
		      ,{field: 'subtitle', title: '商品副标题'}
		      ,{field: 'mainImage', title: '产品主图,URL相对地址', templet:"#mainImageTpl"} 
		      ,{field: 'subImages', title: '图片地址,json格式,扩展用'}
		      ,{field: 'detail', title: '商品详情'}
		      ,{field: 'price', title: '价格',  sort: true}
		      ,{field: 'stock', title: '库存', sort: true}
		      ,{field: 'status', title: '商品状态',  sort: true, templet:"#statusTpl"}
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
		    	x_admin_show('查看商品','${ctx}/product/getProductDetailPage.action?id='+ data.id,700,550);
		    } else if(obj.event === 'del'){
		      layer.confirm('确定删除这个商品吗?', function(index){
		    	  $.ajax({
		    		url:"${ctx}/product/deleteByPrimaryKey.action",
		    		data:{"id":data.id},
		    		dataType:"json",
		    		success:function(resp) {
		    			if(resp.code == util.SUCCESS){
		    				mylayer.success(resp.msg);
		    				//表格重新加载
		    				table.reload("layUITableId");
		    			} else {
		    				mylayer.errorMsg(resp.msg);
		    			}
			        layer.close(index);
		    		}
		    	  });
		      });
		    } else if(obj.event === 'update'){
		      //layer.alert('编辑行：<br>'+ JSON.stringify(data))
		      x_admin_show('更新商品','${ctx}/product/getProductUpdatePage.action?id='+ data.id,700,550);
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
		       layer.confirm('确定删除这些商品吗?', function(index){
			    	$.ajax({
			    		url:"${ctx}/product/deleteAll.action",
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
					  id:$("#searchId").val(),
					  name:$("#searchName").val()
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