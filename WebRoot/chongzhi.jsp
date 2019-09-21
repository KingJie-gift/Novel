<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>读书网 书卷--充值</title>

<link rel="stylesheet" type="text/css" href="css/amazeui.min.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />

</head>
<body>
<div class="pay">
	<!--主内容开始编辑-->
	<div class="tr_recharge">
		<div class="tr_rechtext">
			<p class="te_retit"><img src="images/coin.png" alt="" />充值中心</p>
			<p>1.充值后不会退还谨慎选择。</p>
			<p>2.书卷人民币换算为1：10，即1元=10书卷，你可以选择支付宝或者是微信的付款方式来进行充值，书卷每次100起充。</p>
		</div>
		<div id="tanchu_img"></div>
		<form action="checkServlet?op=addauthorprice" class="am-form" id="doc-vld-msg" method="post">
		<input type="hidden" name="authorid" value="${author.authorid}">
			<div class="tr_rechbox">
				<div class="tr_rechhead">
					<img src="images/ys_head2.jpg" />
					<p>充值ID：
						<a>${author.authorid}</a>
					</p>
					<p>充值昵称：
						<a>${author.authorname}</a>
					</p>
					<div class="tr_rechheadcion">
						<img src="images/coin.png" alt="" />
						<span>当前余额：<span>${author.authorprice}书卷</span></span>
					</div>
				</div>
				<div class="tr_rechli am-form-group">
					<ul class="ui-choose am-form-group" id="uc_01">
						<li>
							<label class="am-radio-inline">
									<input type="radio"  value="" name="authorprice" required data-validation-message="请选择一项充值额度"> 100书卷
								</label>
						</li>
						<li>
							<label class="am-radio-inline">
									<input type="radio" name="authorprice" data-validation-message="请选择一项充值额度"> 200书卷
								</label>
						</li>

						<li>
							<label class="am-radio-inline">
									<input type="radio" name="authorprice" data-validation-message="请选择一项充值额度"> 500书卷
								</label>
						</li>
						<li>
							<label class="am-radio-inline">
									<input type="radio" name="authorprice" data-validation-message="请选择一项充值额度"> 其他金额
								</label>
						</li>
					</ul>
					<!--<span>10书卷=1元 10元起充</span>-->
				</div>
				<div class="tr_rechoth am-form-group">
					<span>其他金额：</span>
					<input type="number" min="10" max="10000" name="authorprice" value="10.00元" class="othbox" data-validation-message="充值金额范围：10-10000元" />
					<!--<p>充值金额范围：10-10000元</p>-->
				</div>
				<div class="tr_rechcho am-form-group">
					<span>充值方式：</span>
					<label class="am-radio">
							<input type="radio" name="radio" value="微信" data-am-ucheck required data-validation-message="请选择一种充值方式"><img src="images/wechatpay.png">
						</label>
					<label class="am-radio" style="margin-right:30px;">
							<input type="radio" name="radio" value="支付宝" data-am-ucheck data-validation-message="请选择一种充值方式"><img src="images/zfbpay.png">
						</label>
				</div>
				<div class="tr_rechnum">
					<span>应付金额：</span>
					
					<p class="rechnum" >0.00</p><em>元</em>
				</div>
			</div>
			<div class="tr_paybox">
			<input type="hidden" id="price" name="price" value="">
				<input type="submit" value="确认支付" class="tr_pay am-btn" />
				<span>温馨提示：招兵币只限于在简历详情中购买简历，遇到问题请拨打联系电话。</span>
			</div>
		</form>
	</div>
</div>

<script type="text/javascript" src="js/jquery.min.js"></script>
<script type="text/javascript" src="js/amazeui.min.js"></script>
<script type="text/javascript" src="js/ui-choose.js"></script>
<script type="text/javascript">
	// 将所有.ui-choose实例化
	$('.ui-choose').ui_choose();
	// uc_01 ul 单选
	var uc_01 = $('#uc_01').data('ui-choose'); // 取回已实例化的对象
	uc_01.click = function(index, item) {
		console.log('click', index, item.text())
	}
	uc_01.change = function(index, item) {
		console.log('change', index, item.text())
	}
	$(function() {
		$('#uc_01 li:eq(3)').click(function() {
			$('.tr_rechoth').show();
			$('.tr_rechoth').find("input").attr('required', 'true')
			$('.rechnum').text('10.00元');
			
			
		})
		$('#uc_01 li:eq(0)').click(function() {
			$('.tr_rechoth').hide();
			$('.rechnum').text('10.00元');
			$('.othbox').val('');
			$("#price").val(100);
			
			
		})
		$('#uc_01 li:eq(1)').click(function() {
			$('.tr_rechoth').hide();
			$('.rechnum').text('20.00元');
			$('.othbox').val('');
			$("#price").val(200);
			
		})
		$('#uc_01 li:eq(2)').click(function() {
			$('.tr_rechoth').hide();
			$('.rechnum').text('50.00元');
			$('.othbox').val('');
			$("#price").val(500);
			
		})
		$(document).ready(function() {
			$('.othbox').on('input propertychange', function() {
				var num = $(this).val();
				
				$("#price").val(num+0);
				$('.rechnum').html(num + ".00元");
			
			});
		});
	})

	$(function() {
		$('#doc-vld-msg').validator({
			onValid: function(validity) {
				$(validity.field).closest('.am-form-group').find('.am-alert').hide();
			},
			onInValid: function(validity) {
				var $field = $(validity.field);
				var $group = $field.closest('.am-form-group');
				var $alert = $group.find('.am-alert');
				// 使用自定义的提示信息 或 插件内置的提示信息
				var msg = $field.data('validationMessage') || this.getValidationMessage(validity);

				if(!$alert.length) {
					$alert = $('<div class="am-alert am-alert-danger"></div>').hide().
					appendTo($group);
				}
				$alert.html(msg).show();
			}
		});
	});
	
</script>
<div style="text-align:center;margin:50px 0; font:normal 14px/24px 'MicroSoft YaHei';">
<p>适用浏览器：360、FireFox、Chrome、Safari、Opera、傲游、搜狗、世界之窗. 不支持IE8及以下浏览器。</p>
<p>来源：<a href="http://sc.chinaz.com/" target="_blank">站长素材</a></p>
</div>
</body>
</html>