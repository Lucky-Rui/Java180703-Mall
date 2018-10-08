<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/common/taglibs.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>修改商品</title>
	<link rel="stylesheet" href="${ctx}/static/back/lib/layui/css/layui.css" media="all">
	<link rel="stylesheet" href="${ctx}/static/back/css/font.css">
	<link rel="stylesheet" href="${ctx}/static/back/css/xadmin.css">
	
	<script src="${ctx}/static/back/lib/jquery/jquery-3.2.1.min.js"></script>
	<script src="${ctx}/static/back/lib/layui/layui.js"></script>
    <script src="${ctx}/static/common/js/util.js"></script>
    <script src="${ctx}/static/common/js/mylayer.js"></script>
    <script src="${ctx}/static/back/js/xadmin.js"></script>
    <script charset="utf-8" src="${ctx}/static/common/kindeditor/kindeditor.js"></script>
	<script charset="utf-8" src="${ctx}/static/common/kindeditor/lang/zh_CN.js"></script>
	<script>
	      KindEditor.ready(function(K) {
	    	  window.editor = K.create('#detail');
	      });
	</script>
</head>
<body>
    <div class="x-body">
		<form class="layui-form layui-form-pane" id="form_update">
		
		  <input type="hidden" id="id" name="id" value="${product.id}"/>
		
		  <div class="layui-form-item">
		    <label class="layui-form-label">商品名称</label>
		    <div class="layui-input-block">
		      <input type="text" name="name" value="${product.name}" autocomplete="off" placeholder="请输入商品名称" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">商品副标题</label>
		    <div class="layui-input-block">
		      <input type="text" name="subtitle" value="${product.subtitle}" lay-verify="required" placeholder="请输入商品副标题" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">商品分类</label>
		    <input type="hidden" id="categoryId" name="categoryName" value="${product.categoryId}"/>
		    <div class="layui-input-inline">
		      <select id="topCategory" lay-filter="topCategoryFilter">
		      </select>
		    </div>
		    <div class="layui-input-inline">
		      <select id="secondCategory" name="categoryId">
		      </select>
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">商品价格</label>
		    <div class="layui-input-inline">
		      <input type="text" name="price" value="${product.price}" placeholder="￥" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">库存</label>
		    <div class="layui-input-inline">
		      <input type="text" name="stock" value="${product.stock}" placeholder="请输入商品的库存" autocomplete="off" class="layui-input">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">商品状态</label>
		    <div class="layui-input-block">
		      <input type="hidden" id="sta" name="sta" value="${product.status}"/>
		      <input type="radio" id="status" name="status" value="1" title="上架">
		      <input type="radio" id="status" name="status" value="0" title="下架">
		    </div>
		  </div>
		  
		  <div class="layui-form-item">
		    <label class="layui-form-label">商品图片</label>
		    <input type="hidden" name="mainImage" id="mainImage"/>
		    <div class="layui-input-block layui-upload">
			  <div class="layui-upload-drag" id="uploadBtn">
				  <img width="120px" height="120px" id="mainImg" src="/productImg/${product.mainImage}">
				  <p id="demoText">点击上传，或将文件拖拽到此处</p>
			  </div>
			</div> 
		  </div>
		 
		  <div class="layui-form-item layui-form-text">
		    <label class="layui-form-label">商品详情</label>
		    <div class="layui-input-block">
		      <textarea  id="detail"  value="${product.detail}" name="detail" placeholder="请输入内容" class="layui-textarea"></textarea>
		    </div>
		  </div>
		</form>
		<button class="layui-btn" onclick="submitForm()">更新</button>
	</div>
	
	<script>
		//页面加载完就执行
		$(function() {
			
			//商品状态回显
			var value = $("#sta").val();//sta为id属性
			$('[name="status"]:radio').each(function() { 
				if (this.value == value) { 
					this.checked = true;
				} 
			});   
			
			//加载一级分类
			$.ajax({
				url : "${ctx}/category/selectTopCategory.action",
				type : "post",
				dataType : "json",
				success : function(resp) {
					console.log(resp);
					if(resp.code == util.SUCCESS) {
						var html = "<option value=''>请选择一级分类</option>";
						var data = resp.data;
						for(var i = 0; i < data.length; i++) {
							html += "<option value='"+data[i].id+"'>"+data[i].name+"</option>"
						}
						$("#topCategory").html(html);
					} else {
					}
				}
			});
			
		});
	
		layui.use(['form', 'upload'], function(){
		  var form = layui.form;
		  var upload = layui.upload;
		  
		  //刷新select选择框渲染
		  form.render('select');
		  //监听select选择
		  //下拉选择框被选中时触发，回调函数返回一个object参数，携带两个成员：
		  form.on('select(topCategoryFilter)', function(data){
			  console.log(data.elem); //得到select原始DOM对象
			  console.log(data.value); //得到被选中的值
			  console.log(data.othis); //得到美化后的DOM对象
			  $.ajax({
				url : "${ctx}/category/selectSecondCategory.action",
				type : "post",
				data : {"topCategoryId" : data.value},
				dataType : "json",
				success : function(resp) {
					console.log(resp);
					if(resp.code == util.SUCCESS) {
						var html = "<option value=''>请选择二级分类</option>";
						var categoryId = $("#categoryId").val();
						var data = resp.data;
						for(var i = 0; i < data.length; i++) {
							if(data[i].id == categoryId){
								html += "<option value='"+data[i].id+"'>"+data[i].name+"</option>"
							}
							if(data[i].id != categoryId){
								html += "<option value='"+data[i].id+"'>"+data[i].name+"</option>"
							}
						}
						$("#secondCategory").html(html);
						//刷新select选择框渲染
						form.render('select'); 
					} else {
					}
				}
			  });
		  });   
		  
		  //图片拖拽上传
		  upload.render({
		    elem: '#uploadBtn'
		    ,url: '${ctx}/upload/uploadImg.action'
	    	,before: function(obj){
		       //预读本地文件示例，不支持ie8
		       obj.preview(function(index, file, result){
		         $('#mainImg').attr('src', result); //图片链接（base64）
		      });
		    }
		    ,done: function(resp){
		    	//上传成功
		       if(resp.code == util.SUCCESS) {
		    	   //给这个隐藏标签填上value值<input type="hidden" name="mainImage" id="mainImage"/>
		    	   $("#mainImage").val(resp.data);
		    	   mylayer.success("上传成功");
		       }
		    }
		    ,error: function(){
		      //失败状态，并实现重传
		      var demoText = $('#demoText');
		      demoText.html('<span style="color: #FF5722;">上传失败</span> <a class="layui-btn layui-btn-xs demo-reload">重试</a>');
		      demoText.find('.demo-reload').on('click', function(){
		        uploadInst.upload();
		      });
		    }
		  });
		});
		
		//用ajax方式提交form表单
		function submitForm(){
			$.ajax({
				url : '${ctx}/product/updateByPrimaryKey.action',
				data : $('#form_update').serialize(),
				type : 'POST',
				dataType : 'json',
				success : function(resp) {
					if(resp.code == util.SUCCESS) {
						layer.alert("添加成功", {icon: 1,time :3000},function () {
			                // 获得获取当前弹出层的层级
			                var index = parent.layer.getFrameIndex(window.name);
			                //关闭弹出层
			                parent.layer.close(index);
			                //刷新父页面
			                window.parent.location.reload();
						});
					} else {
						//添加失败
						mylayer.errorMsg(resp.msg);
					}
				}
			});
		}
	</script>
	
	
</body>
</html>