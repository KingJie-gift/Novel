//选项卡效果
function setTab(m, n) {
	var tli = document.getElementById("tt_" + m).getElementsByTagName("span");
	var mli = document.getElementById("mm_" + m).getElementsByTagName("ul");
	for (i = 0; i < tli.length; i++) {
		tli[i].className = i == n ? "hover": "";
		mli[i].style.display = i == n ? "block": "none";
	}
}
$(function(){
	var slideHtml = $('#bb-bookblock')[0].innerHTML;
	var hdHtml = '<div class="hd"><ul>';
	var count = $('[data-slide]').find('.bb-item').length;
	for (var i = 1; i <= count; i++) {
		if(i==1){
			hdHtml += '<li class="on">'+(i)+'</li>';
		}else{
			hdHtml += '<li>'+(i)+'</li>';
		}
	}
	hdHtml += '</ul></div>';
	slideHtml += hdHtml;
	slideHtml += '<a class="prev" href="javascript:void(0)"></a><a class="next" href="javascript:void(0)"></a>';

	jQuery("[data-slide]").html(slideHtml);

	var Page = (function() {
		var config = {
			$bookBlock : $( '[data-slide]' ),
			$navNext : $( '.next' ),
			$navPrev : $( '.prev' ),
			$navFirst : $( '.hd ul li:first-child' ),
			$navLast : $( '.hd ul li:last-child' )
		},
		init = function() {
			config.$bookBlock.bookblock( {
				speed : 800,
				shadowSides : 0.8,
				shadowFlip : 0.7,
				// autoplay: true,
				circular: true,
				onEndFlip: function(old, page, isLimit){
					$('.hd li:nth-child('+(page+1)+')').addClass('on').siblings('.on').removeClass('on');
					auto();
				}
			});
			initEvents();
		},
		initEvents = function() {
			var _this = this;
			var $slides = config.$bookBlock.children();
			config.$navNext.on('click touchstart',function(){
				config.$bookBlock.bookblock('next');
				return false;
			} );
			config.$navPrev.on('click touchstart',function(){
				config.$bookBlock.bookblock('prev');
				return false;
			} );
			config.$navFirst.on('click touchstart',function(){
				config.$bookBlock.bookblock('first');
				return false;
			} );
			config.$navLast.on('click touchstart',function(){
				config.$bookBlock.bookblock('last');
				return false;
			} );
			$slides.on( {
				'swipeleft' : function( event ) {
					config.$bookBlock.bookblock( 'next' );
					return false;
				},
				'swiperight' : function( event ) {
					config.$bookBlock.bookblock( 'prev' );
					return false;
				}
			} );
			$( document ).keydown( function(e) {
				var keyCode = e.keyCode || e.which,
				arrow = {
					left : 37,
					up : 38,
					right : 39,
					down : 40
				};
				switch (keyCode) {
					case arrow.left:
					config.$bookBlock.bookblock( 'prev' );
					break;
					case arrow.right:
					config.$bookBlock.bookblock( 'next' );
					break;
				}
			}).on('mouseenter','.hd li',function(){
				if($(this).hasClass('on')){
					return false;
				}
				$(this).addClass('on').siblings('.on').removeClass('on')
				config.$bookBlock.bookblock('jump',($(this).index()+1));
			});

			auto();
		},
		auto = function(){
			clearInterval(this.autoplay);
			this.autoplay = setInterval(function(){
				config.$bookBlock.bookblock( 'next' );
			},3000);
		};
		return { init : init };
	})();

	Page.init();

	if($('.singleBook .bookName').height() <= 35){
		$('.newArticle').removeClass('nodis');
	}else{
		$('.newArticle').addClass('nodis');
	}

	// 男生女生切换
	$(document).on('click mouseenter','[data-click]',function(){
		if($(this).hasClass('active')){
			return false;
		}
		var parClass = $(this).data('par');
		var comClass = $(this).data('com');
		$(this).addClass('active').siblings('.active').removeClass('active');
		var className = $(this).data('class');
		$(this).closest('.'+parClass).find('.'+comClass).addClass('nodis').siblings('.'+className).removeClass('nodis');
	}).on('mouseenter mouseleave','.contentBox .types ul.typelist li a',function(e){
		var $img = $(this).find('img');
		if(!$img.data('hoversrc')){
			var src = $img.prop('src');
			var hoverSrc = src.substring(0,src.indexOf('.png')) + '_active.png' + src.substring(src.substring(0,src.indexOf('.png')).length + 4);
			
			$img.data('hoversrc',hoverSrc).data('src',src);
		}

		if(e.type == 'mouseenter'){
			$img.attr('src',$img.data('hoversrc'));
		}else{
			$img.attr('src',$img.data('src'));
		}
	}).on('mouseenter mouseleave','.contentBox .types ul.typelist li a',function(e){
		var index = $(this).index();
		if(index == 0){
			return false;
		}
		if(e.type == 'mouseenter'){
			$(this).closest('li').find('a:nth-child('+(index+1)+')').addClass('noBefor');
		}else{
			$(this).closest('li').find('a:nth-child('+(index+1)+')').removeClass('noBefor');
		}
	}).on('mouseenter mouseleave','.recommendCon li:first-child',function(e){
		var $span = $(this).closest('.recommend').find('.title').find('span.active');
		if(e.type == 'mouseenter'){
			/*移入*/
			$span.addClass('active1');
		}else{
			/*移出*/
			$span.removeClass('active1');
		}
	}).on('click','.contentBox .books .sexBox .changeBox .bookInfo,.dszq .books li,.nanshengzhuanqu .books li .book,.nvshengzhuanqu .books li .book',function(e){
		if(e.target.tagName.toLowerCase() != 'a'){
			e.stopPropagation();
			var $a = $($(this).find('a')[0]);
			var url = $a.prop('href');
			var tar = $a.prop('target').toLowerCase();
			if(tar == '_blank'){
				window.open(url);
			}else{
				window.location.href = url;
			}
			return false;
		}
	});

	// 获取用户信息
	var JS_HOST_HOST = '//www.kanshu.com/';

	$(document).on('click','.loginOut',function(){
		var f = 0;
		var url = window.location.href;
		var arr = url.split('/');
		jQuery.getScript(JS_HOST_HOST+"user/loginOut", function(){
			if(f == 1){
				if(arr[3] != 'user' ){
					arr = url.split('#');
					if(arr[3]=='author' && arr[3]=='authorLogin'){
						window.location.href = JS_HOST_HOST+'new/login/showLogin';
						try{window.event.returnValue = false;}catch(e){}
					}else if(arr[1]){
						window.location.href = JS_HOST_HOST+'new/login/showLogin#'+arr[1];
						try{window.event.returnValue = false;}catch(e){}
					}else{
						window.location.href = JS_HOST_HOST+'new/login/showLogin#'+arr[0];
						try{window.event.returnValue = false;}catch(e){}
					}
				}else{
					window.location.href = JS_HOST_HOST+'new/login/showLogin';
					try{window.event.returnValue = false;}catch(e){}
				}
			}else if(f == 2){
				window.location.href = JS_HOST_HOST+'author/authorLogin';
				try{window.event.returnValue = false;}catch(e){}
			}else{
				window.location.href = JS_HOST_HOST+'new/login/showLogin';
				try{window.event.returnValue = false;}catch(e){}
			}
		});
	}).on('click','#search_btn',function(){
		var searchkey = $.trim($('#search_txt').val());
		if (searchkey == "") {
			searchkey = $('#search_txt').prop('placeholder');
			// alert("请输入查询条件!");
			// return false;
		}
		window.location.href = "http://so.kanshu.com/searchList/searchListGO?keys=" + encodeURIComponent(searchkey) + "&sort=1";
	}).on('keyup','#search_txt',function(e){
		if(e.keyCode == 13){
			$('#search_btn').trigger('click');
		}
	}).on('focus','#search_txt',function(){
		if($(this).val().length <= 0){
			$(this).data('placeholder',$(this).attr('placeholder'));
			$(this).attr('placeholder','');
		}
	}).on('blur','#search_txt',function(){
		if($(this).val().length <= 0){
			$(this).attr('placeholder',$(this).data('placeholder'));
		}
	});

	$('.dszq .books li div.bookName').each(function(){
		if($(this).height() > 30){
			$(this).siblings('.labels').addClass('nodis');
		}else{
			$(this).siblings('.labels').removeClass('nodis');
		}
	});

	$('.scal').each(function(){
		$(this).addClass('oh clearfix bookShadow');
		$(this).find('img').removeClass('bookShadow');
		if($(this).find('img').hasClass('fl')){
			$(this).addClass('fl');
		}
		$(this).css({
			width: $(this).find('img').width(),
			height: $(this).find('img').height()
		});
	});

	try{
		$.getScript(JS_HOST_HOST+"user/loadheadernew?rnd="+Math.random(),
			function(){
				msg=msg.split("|*|");
				if(msg[0]=="1"){
					$("nav.menu a:last-child").remove();
					$("nav.menu").append(msg[4]);
					if(msg[1]!="0"){
						// 登录
						var loginHtml = msg[1];
						var userName = loginHtml.substr(loginHtml.indexOf('cd_a aaa')+10,loginHtml.substr(loginHtml.indexOf('cd_a aaa')+10).indexOf('<img'));
						var msgCount = 0;
						// $('.menuTop .container .fr');
						$.ajax({
							type: "POST",
							dataType: "json",
							url: JS_HOST_HOST+"/mhome/userNewMsg",
							data: "userNewMsg=1",
							success: function(data){
								if(data !='1111' && data !='2222'){
									var data = eval(data);
              		//消息
              		if(data[1].xx == '111'){
              			msgCount = data[1].xx_num || 0;
              		}
              	}
              },
              complete: function(){
              	var tempHtml =  '<a href="'+JS_HOST_HOST+'home/user">你好，' + userName + '</a>' +
              	'<a href="'+JS_HOST_HOST+'occasionally/xiaoxichakan" ';
              	if(msgCount > 0){
              		tempHtml += ' class="active2" ';
              	}
              	tempHtml += ' >消息(' + msgCount + ')</a>' +
              	'<a href="javascript:void(0);" class="loginOut">退出</a>';

              	$('.menuTop').addClass('login').find('.fr').html(tempHtml);
              }
            });
					}else{
						// 未登录
						var tempHtml =  '<a href="'+JS_HOST_HOST+'new/login/showLogin#'+window.location.href+'" class="active">登录</a>' +
						'<a href="'+JS_HOST_HOST+'new/user/pcRegister">注册</a>';
						$('.menuTop').removeClass('login').find('.fr').html(tempHtml);
					}
				}
			});
	}catch(error){}
});