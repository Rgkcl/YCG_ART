/*首页banner*/
jQuery(".banner").slide({
	titCell: ".hd ul",
	mainCell: ".bd ul",
	effect: "fold",
	autoPlay: true,
	autoPage: true,
	trigger: "click"
});

/*艺术家滚动*/
jQuery(".scrollBox").slide({
	titCell: ".list li",
	mainCell: ".piclist",
	effect: "left",
	vis: 4,
	scroll: 1,
	delayTime: 800,
	trigger: "click",
	easing: "easeOutCirc"
});

/*弹框盒子*/
$(function() {
	$(".alertbox").click(function() {
		$("#mask").stop().show();
	})
	$("#mask .close").click(function() {
		$("#mask").stop().hide();
	})
});
$(".check-inline,.check-box").click(function() {
	$(this).siblings().removeClass("check_on");
	if($(this).hasClass("check_on")) {
		$(this).removeClass("check_on");
	} else {
		$(this).addClass("check_on");
	}
})
/*付款页　订单详情展开*/		
$(".r-suc-info .detail-show").click(function(){
  $(this).siblings().removeClass("show-on");
  if($(this).hasClass("show-on")){
   $(this).removeClass("show-on");
   $(".order-show").hide();
  }else{
   $(this).addClass("show-on");
   $(".order-show").show();
	  }

})

/*放大镜插件*/
  $(document).ready(function(){
	  var showproduct = {
		  "boxid":"showbox",
		  "sumid":"showsum",
		  "boxw":420,//宽度,该版本中请把宽高填写成一样
		  "boxh":420,//高度,该版本中请把宽高填写成一样
		  "sumw":60,//列表每个宽度,该版本中请把宽高填写成一样
		  "sumh":60,//列表每个高度,该版本中请把宽高填写成一样
		  "sumi":10,//列表间隔
		  "sums":5,//列表显示个数
		  "sumsel":"sel",
		  "sumborder":1,//列表边框，没有边框填写0，边框在css中修改
		  "lastid":"showlast",
		  "nextid":"shownext"
		  };//参数定义	  
	 $.ljsGlasses.pcGlasses(showproduct);//方法调用，务必在加载完后执行
  });

//产品图片滚动效果
	jQuery(".proscroll").slide({ mainCell:".prolist", effect:"leftLoop",vis:5, autoPlay:true});
//商品详情切换
	jQuery(".pro-detail").slide({ titCell:".tab-hd li",trigger:"click", mainCell:".tab-bd",delayTime:0 });
//专场详情图片切换
	jQuery(".spdetail").slide({ mainCell:".bd ul",effect:"fold",autoPlay:true,delayTime:200 });

