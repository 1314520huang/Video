<%@ page language="java" contentType="text/html;charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>影视上传</title>
<%@ include file="../common.jsp"%>
<meta name="renderer" content="webkit">
<link rel="stylesheet" href="${ctx }/static/layui/css/layui.css" media="all">
<script type="text/javascript" src="${ctx }/static/layui/layui.all.js"></script>
</head>
<body>

	<jsp:include page="../head.jsp"></jsp:include>
	<form class="layui-form" action="" style="width: 80%; margin: 0 auto">

		<div class="layui-form-item">
			<label class="layui-form-label">资源名称： </label>
			<div class="layui-input-block">
				<input type="text" id="name" autocomplete="off"
					placeholder="请输入资源名称" class="layui-input">
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">影片分类</label>
			<div class="layui-input-block">
				<select id="belong">
					<option value="">--请选择--</option>
					<option value="0">电影</option>
					<option value="1">动画</option>
					<option value="2">电视剧</option>
				</select>
			</div>
		</div>

		<div class="layui-form-item">
			<label class="layui-form-label">归属地： </label>
			<div class="layui-input-block">
				<select id="country">
					<option value="">--请选择--</option>
					<option value="AL">阿尔巴尼亚</option>
					<option value="DZ">阿尔及利亚</option>
					<option value="AF">阿富汗</option>
					<option value="AR">阿根廷</option>
					<option value="AE">阿拉伯联合酋长国</option>
					<option value="AW">阿鲁巴</option>
					<option value="OM">阿曼</option>
					<option value="AZ">阿塞拜疆</option>
					<option value="EG">埃及</option>
					<option value="ET">埃塞俄比亚</option>
					<option value="IE">爱尔兰</option>
					<option value="EE">爱沙尼亚</option>
					<option value="AD">安道尔</option>
					<option value="AO">安哥拉</option>
					<option value="AI">安圭拉岛</option>
					<option value="AG">安提瓜和巴布达</option>
					<option value="AT">奥地利</option>
					<option value="AX">奥兰岛</option>
					<option value="AU">澳大利亚</option>
					<option value="MO">中国澳门特别行政区</option>
					<option value="BB">巴巴多斯</option>
					<option value="PG">巴布亚新几内亚</option>
					<option value="BS">巴哈马</option>
					<option value="PK">巴基斯坦</option>
					<option value="PY">巴拉圭</option>
					<option value="PS">巴勒斯坦民族权力机构</option>
					<option value="BH">巴林</option>
					<option value="PA">巴拿马</option>
					<option value="BR">巴西</option>
					<option value="BY">白俄罗斯</option>
					<option value="BM">百慕大群岛</option>
					<option value="BG">保加利亚</option>
					<option value="MP">北马里亚纳群岛</option>
					<option value="BJ">贝宁</option>
					<option value="BE">比利时</option>
					<option value="IS">冰岛</option>
					<option value="PR">波多黎各</option>
					<option value="PL">波兰</option>
					<option value="BA">波斯尼亚和黑塞哥维那</option>
					<option value="BO">玻利维亚</option>
					<option value="BZ">伯利兹</option>
					<option value="BW">博茨瓦纳</option>
					<option value="BQ">博内尔</option>
					<option value="BT">不丹</option>
					<option value="BF">布基纳法索</option>
					<option value="BI">布隆迪</option>
					<option value="BV">布韦岛</option>
					<option value="KP">朝鲜</option>
					<option value="GQ">赤道几内亚</option>
					<option value="DK">丹麦</option>
					<option value="DE">德国</option>
					<option value="TL">东帝汶</option>
					<option value="TG">多哥</option>
					<option value="DO">多米尼加共和国</option>
					<option value="DM">多米尼克</option>
					<option value="RU">俄罗斯</option>
					<option value="EC">厄瓜多尔</option>
					<option value="ER">厄立特里亚</option>
					<option value="FR">法国</option>
					<option value="FO">法罗群岛</option>
					<option value="PF">法属波利尼西亚</option>
					<option value="GF">法属圭亚那</option>
					<option value="TF">法属南极地区</option>
					<option value="VA">梵蒂冈城</option>
					<option value="PH">菲律宾</option>
					<option value="FJ">斐济群岛</option>
					<option value="FI">芬兰</option>
					<option value="CV">佛得角</option>
					<option value="FK">福克兰群岛(马尔维纳斯群岛)</option>
					<option value="GM">冈比亚</option>
					<option value="CD">刚果(DRC)</option>
					<option value="CG">刚果共和国</option>
					<option value="CO">哥伦比亚</option>
					<option value="CR">哥斯达黎加</option>
					<option value="GG">格恩西岛</option>
					<option value="GD">格林纳达</option>
					<option value="GL">格陵兰</option>
					<option value="GE">格鲁吉亚</option>
					<option value="CU">古巴</option>
					<option value="GP">瓜德罗普岛</option>
					<option value="GU">关岛</option>
					<option value="GY">圭亚那</option>
					<option value="KZ">哈萨克斯坦</option>
					<option value="HT">海地</option>
					<option value="KR">韩国</option>
					<option value="NL">荷兰</option>
					<option value="HM">赫德和麦克唐纳群岛</option>
					<option value="ME">黑山共和国</option>
					<option value="HN">洪都拉斯</option>
					<option value="KI">基里巴斯</option>
					<option value="DJ">吉布提</option>
					<option value="KG">吉尔吉斯斯坦</option>
					<option value="GN">几内亚</option>
					<option value="GW">几内亚比绍</option>
					<option value="CA">加拿大</option>
					<option value="GH">加纳</option>
					<option value="GA">加蓬</option>
					<option value="KH">柬埔寨</option>
					<option value="CZ">捷克共和国</option>
					<option value="ZW">津巴布韦</option>
					<option value="CM">喀麦隆</option>
					<option value="QA">卡塔尔</option>
					<option value="KY">开曼群岛</option>
					<option value="CC">科科斯群岛(基灵群岛)</option>
					<option value="KM">科摩罗联盟</option>
					<option value="CI">科特迪瓦共和国</option>
					<option value="KW">科威特</option>
					<option value="HR">克罗地亚</option>
					<option value="KE">肯尼亚</option>
					<option value="CK">库可群岛</option>
					<option value="CW">库拉索</option>
					<option value="LV">拉脱维亚</option>
					<option value="LS">莱索托</option>
					<option value="LA">老挝</option>
					<option value="LB">黎巴嫩</option>
					<option value="LT">立陶宛</option>
					<option value="LR">利比里亚</option>
					<option value="LY">利比亚</option>
					<option value="LI">列支敦士登</option>
					<option value="RE">留尼汪岛</option>
					<option value="LU">卢森堡</option>
					<option value="RW">卢旺达</option>
					<option value="RO">罗马尼亚</option>
					<option value="MG">马达加斯加</option>
					<option value="IM">马恩岛</option>
					<option value="MV">马尔代夫</option>
					<option value="MT">马耳他</option>
					<option value="MW">马拉维</option>
					<option value="MY">马来西亚</option>
					<option value="ML">马里</option>
					<option value="MK">马其顿, 前南斯拉夫共和国</option>
					<option value="MH">马绍尔群岛</option>
					<option value="MQ">马提尼克岛</option>
					<option value="YT">马约特岛</option>
					<option value="MU">毛里求斯</option>
					<option value="MR">毛利塔尼亚</option>
					<option value="US">美国</option>
					<option value="AS">美属萨摩亚</option>
					<option value="UM">美属外岛</option>
					<option value="VI">美属维尔京群岛</option>
					<option value="MN">蒙古</option>
					<option value="MS">蒙特塞拉特</option>
					<option value="BD">孟加拉国</option>
					<option value="PE">秘鲁</option>
					<option value="FM">密克罗尼西亚</option>
					<option value="MM">缅甸</option>
					<option value="MD">摩尔多瓦</option>
					<option value="MA">摩洛哥</option>
					<option value="MC">摩纳哥</option>
					<option value="MZ">莫桑比克</option>
					<option value="MX">墨西哥</option>
					<option value="NA">纳米比亚</option>
					<option value="ZA">南非</option>
					<option value="AQ">南极洲</option>
					<option value="GS">南乔治亚和南德桑威奇群岛</option>
					<option value="NR">瑙鲁</option>
					<option value="NP">尼泊尔</option>
					<option value="NI">尼加拉瓜</option>
					<option value="NE">尼日尔</option>
					<option value="NG">尼日利亚</option>
					<option value="NU">纽埃</option>
					<option value="NO">挪威</option>
					<option value="NF">诺福克岛</option>
					<option value="PW">帕劳群岛</option>
					<option value="PN">皮特凯恩群岛</option>
					<option value="PT">葡萄牙</option>
					<option value="JP">日本</option>
					<option value="SE">瑞典</option>
					<option value="CH">瑞士</option>
					<option value="SV">萨尔瓦多</option>
					<option value="WS">萨摩亚</option>
					<option value="RS">塞尔维亚共和国</option>
					<option value="SL">塞拉利昂</option>
					<option value="SN">塞内加尔</option>
					<option value="CY">塞浦路斯</option>
					<option value="SC">塞舌尔</option>
					<option value="XS">沙巴岛</option>
					<option value="SA">沙特阿拉伯</option>
					<option value="BL">圣巴泰勒米岛</option>
					<option value="CX">圣诞岛</option>
					<option value="ST">圣多美和普林西比</option>
					<option value="SH">圣赫勒拿岛</option>
					<option value="KN">圣基茨和尼维斯</option>
					<option value="LC">圣卢西亚</option>
					<option value="MF">法属圣马丁岛</option>
					<option value="SX">荷属圣马丁岛</option>
					<option value="SM">圣马力诺</option>
					<option value="PM">圣皮埃尔岛和密克隆岛</option>
					<option value="VC">圣文森特和格林纳丁斯</option>
					<option value="XE">圣尤斯特歇斯岛</option>
					<option value="LK">斯里兰卡</option>
					<option value="SK">斯洛伐克</option>
					<option value="SI">斯洛文尼亚</option>
					<option value="SZ">斯威士兰</option>
					<option value="SD">苏丹</option>
					<option value="SR">苏里南</option>
					<option value="SB">所罗门群岛</option>
					<option value="SO">索马里</option>
					<option value="TJ">塔吉克斯坦</option>
					<option value="TW">中国台湾</option>
					<option value="TH">泰国</option>
					<option value="TZ">坦桑尼亚</option>
					<option value="TO">汤加</option>
					<option value="TC">特克斯和凯科斯群岛</option>
					<option value="TT">特立尼达和多巴哥</option>
					<option value="TN">突尼斯</option>
					<option value="TV">图瓦卢</option>
					<option value="TR">土耳其</option>
					<option value="TM">土库曼斯坦</option>
					<option value="TK">托克劳</option>
					<option value="WF">瓦利斯和富图纳</option>
					<option value="VU">瓦努阿图</option>
					<option value="GT">危地马拉</option>
					<option value="VG">维尔京群岛(英属)</option>
					<option value="VE">委内瑞拉</option>
					<option value="BN">文莱</option>
					<option value="UG">乌干达</option>
					<option value="UA">乌克兰</option>
					<option value="UY">乌拉圭</option>
					<option value="UZ">乌兹别克斯坦</option>
					<option value="ES">西班牙</option>
					<option value="GR">希腊</option>
					<option value="HK">中国香港特别行政区</option>
					<option value="SG">新加坡</option>
					<option value="NC">新喀里多尼亚</option>
					<option value="NZ">新西兰</option>
					<option value="HU">匈牙利</option>
					<option value="SY">叙利亚</option>
					<option value="JM">牙买加</option>
					<option value="AM">亚美尼亚</option>
					<option value="SJ">扬马延岛</option>
					<option value="YE">也门</option>
					<option value="IQ">伊拉克</option>
					<option value="IR">伊朗</option>
					<option value="IL">以色列</option>
					<option value="IT">意大利</option>
					<option value="IN">印度</option>
					<option value="ID">印度尼西亚</option>
					<option value="UK">英国</option>
					<option value="IO">英属印度洋领地</option>
					<option value="JO">约旦</option>
					<option value="VN">越南</option>
					<option value="ZM">赞比亚</option>
					<option value="JE">泽西</option>
					<option value="TD">乍得</option>
					<option value="GI">直布罗陀</option>
					<option value="CL">智利</option>
					<option value="CF">中非共和国</option>
					<option value="CN">中国</option>
				</select>
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">发行年份： </label>
			<div class="layui-input-inline">
				<input type="text" class="layui-input" id="year" placeholder="yyyy" value="2018">
			</div>
		</div>


		<div class="layui-form-item">
			<label class="layui-form-label">类型</label>
			<div class="layui-input-block">
				<select id="type" lay-filter="aihao">
					<option value="">--请选择--</option>
					<option value="0">科幻</option>
					<option value="1">喜剧</option>
					<option value="2">爱情</option>
					<option value="2">动作</option>
				</select>
			</div>
		</div>

		<div class="layui-form-item layui-form-text">
			<label class="layui-form-label">电影简介</label>
			<div class="layui-input-block">
				<textarea id="detail" placeholder="请讲述一下电影的一些基本介绍......"
					class="layui-textarea"></textarea>
			</div>
		</div>
		<div class="layui-upload">
			<label class="layui-form-label">封面图片</label>
			<div class="layui-upload layui-input-block">
				<img class="layui-upload-img" id="headImg" src="${ctx }/upload/nofind.jpg" style="height: 120px;"> 
					<input type="hidden" id="imageUrl" src=""/> 
				    <button type="button" class="layui-btn layui-btn-primary" id="fileBtn">
						<i class="layui-icon">&#xe67c;</i>选择封面相册
					</button>
					<button type="button" class="layui-btn layui-btn-warm" id="uploadBtn">开始上传</button>
			</div>
		</div>
	</form>
	<div class="layui-upload" style="text-align: center;">
		<button type="button" class="layui-btn" id="upload">开始上传</button>
		<button type="button" class="layui-btn layui-btn-normal"
			id="chooseFile">选择文件</button>
	</div>
	<div id="uploadPatchForm" style="display: none" class="roundRect">
		    
		<div id="uploadLoadingDiv">
			<div class="layui-progress" lay-showpercent="true" lay-filter="demo">
				     
				<div class="layui-progress-bar layui-bg-red" lay-percent="0%"></div>
				        
			</div>
			    
		</div>
	</div>

	<br>
	<br>
	<jsp:include page="../foot.jsp"></jsp:include>
</body>
<script>
	var ctx = "${ctx}";
	var xhrOnProgress = function(fun) {
		xhrOnProgress.onprogress = fun; //绑定监听
		//使用闭包实现监听绑
		return function() {
			//通过$.ajaxSettings.xhr();获得XMLHttpRequest对象
			var xhr = $.ajaxSettings.xhr();
			//判断监听函数是否为函数
			if (typeof xhrOnProgress.onprogress !== 'function')
				return xhr;
			//如果有监听函数并且xhr对象支持绑定时就把监听函数绑定上去
			if (xhrOnProgress.onprogress && xhr.upload) {
				xhr.upload.onprogress = xhrOnProgress.onprogress;
			}
			return xhr;
		}
	}
	
	layui.use('upload', function() {
		var upload = layui.upload;
		upload.render({
			elem : '#fileBtn',
			url : '${ctx}/files',
			accept : 'file',
			auto : false,
			bindAction : '#uploadBtn',
			done : function(res) {
				$("#headImg").attr("src", res.data);
				$("#imageUrl").val(res.data);
			}
		});
	});
	
	layui.use(
		[ 'upload', 'element', 'layer' ], function() {
			var $ = layui.jquery, upload = layui.upload, element = layui.element, layer = layui.layer;
			upload.render({
				elem : '#chooseFile',
				url : '${ctx}/files',
				accept : 'file',
				auto : false,
				data : {
					upgradeType : function() {
						return $(
							"input[name='upgradeType']:checked").val();
					}
				},
				xhr : xhrOnProgress,
				bindAction : '#upload',
				progress : function(e, percent) {
					console.log("进度：" + percent + '%');
					element.progress('demo', percent + '%');
				},
				before : function(obj) {
					layer.msg('文件正在上传中，请等待"', {
						icon : 16,
						shade : 0.01
					});
				},
				done : function(res) {
					// 影视资源上传成功之后，开始上传普通的影视信息
					uploadInfo(res.data);
					layer.msg("上传成功");
					setTimeout(function() {
						layer.closeAll('loading')
					});
				}
			});
	});

	layui.use('laydate', function() {
		var laydate = layui.laydate;
		laydate.render({
			elem : '#year',
			type : 'year'
		});
	});

	layui.use('form', function() {
		var form = layui.form;
		form.render();
	});

	function uploadInfo(url) {

		var video = {};
		video.name = $("#name").val();
		video.country = $("#country").find("option:selected").text();
		video.detail = $("#detail").val();
		video.year = $("#year").val();
		video.belongKey = $("#belong").find("option:selected").val();
		video.belongValue = $("#belong").find("option:selected").text();
		video.type = $("#type").find("option:selected").val();
		video.value = $("#type").find("option:selected").text();
		video.imgUrl = $("#imageUrl").val();
		video.videoUrl = url;
		console.log(video);
		$.ajax({
			url : "${ctx}/videos",
			method : 'post',
			cache : false,
			data : video,
			dataType : 'json',
			success : function(res) {
				if (res.code != 0)
					layer.alert(res.message);
				else {
					alert("上传成功");
					window.location.href = ctx;
				}
			},
			error : function() {
				layer.alert("网络连接有误，请稍后！")
			}
		});
	}
</script>
</html>