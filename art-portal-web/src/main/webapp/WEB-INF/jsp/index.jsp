<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>

	<head>
		<meta name="renderer" content="webkit|ie-comp|ie-stand">
		<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
		<meta charset='utf-8'>
		<meta http-equiv="Cache-Control" content="no-siteapp" />
		<title>首页</title>
		<meta name="viewport" content="width=device-width,initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
		<meta http-equiv="Cache-Control" content="no-siteapp">
		<meta name="apple-mobile-web-app-capable" content="yes">
		<meta name="mobile-web-app-capable" content="yes">
		<meta name="format-detection" content="telephone=no">
		<meta name="keywords" content="">
		<meta name="description" content="">
		<link rel="stylesheet" type="text/css" href="css/page.css" />
		<link rel="stylesheet" type="text/css" href="css/base.css" />
		<script src="js/jquery-1.8.3.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="js/jquery.SuperSlide.2.1.js"></script>		
	</head>
	
	<body>
		<!--header star-->
		<div class="header clearfix">			
			<div class="top clearfix">
				<div class="topctent clearfix">
					<div class="left clearfix fl">
						公告：您好，欢迎登录北京椿龄文化发展有限公司
					</div>
					<div class="right clearfix fr">
						<div class="zuo clearfix fl">
							<ul class="clearfix fl">
								<li>
									<span class="fl">欢迎</span>
									<a href="grxx.html" class="fl">瑾晨0212</a>
									<span class="fl">进入商城</span>
								</li>
								<li>
									<a href="register.html">
										免费注册
									</a>
								</li>
								<li>
									<a href="settled.html">
										艺术家入驻
									</a>
								</li>
							</ul>
						</div>						
						<div class="shopcar-btn clearfix fl">
							<a href="shopping.html" class="box-s">
								购物车（0）
							</a>
						</div>
						<div class="fenxiang clearfix fl">
							<span class="fl">分享到：</span>
							<ul class="clearfix fl">
								<li><a href="#"><img src="img/sina.png"/></a></li>
								<li><a href="#"><img src="img/qq.png"/></a></li>
								<li><a href="#"><img src="img/wechat.png"/></a></li>
							</ul>
						</div>
					</div>					
				</div>
			</div>			
			<div class="bottom clearfix">
				<div class="logo clearfix">
					<a href="index.html"></a>
				</div>
				<div class="search clearfix fr ra5">
					<input type="text" class="fl" name="" id="" value="" placeholder="请输入您要搜索的内容" />
					<input type="button" name="" id="" value="搜索" class="fl box-s" />
				</div>
			</div>
		</div>
		<!--header end-->
		
		<!--navbar star-->
		<div class="navbar clearfix">
			<div class="content clearfix">
				<ul>
					<li class="cur"><a href="index.html">首页</a></li>
					<li><a href="special.html">专场</a></li>
					<li><a href="mall.html">商城</a></li>
					<li><a href="artist.html">艺术家</a></li>
				</ul>
			</div>
		</div>
		<!--navbar end-->
	
		<!--banner star-->
		<div class="banner">		
			<div class="bd">
				<ul>
				   <c:forEach items="${ad1}" var="ad">
				    <li style="background:url(${ad.src}) #194982 center 0 no-repeat;"><a href="${ad.src}"></a></li>
				   </c:forEach>
				</ul>
			</div>
			<div class="hd"><ul></ul></div>
		</div>
		<!--banner end-->
		
<!--recom star-->
		<div class="recom clearfix">
			<div class="content clearfix">
				<div class="recom-tit clearfix">
					<p class="engtit ta-center">
						RECOMMENDS
					</p>
					<div class="middle clearfix">
						<span class="line"></span>
						<span class="wenzi">今日推荐</span>
						<span class="line"></span>
					</div>
					<p class="fu-tit">
						好作品无需多说 你会由心的看清它的诉说
					</p>
				</div>
				<div class="bottom clearfix box-s">
					<div class="left clearfix fl">
						<div class="listone clearfix fl">
							<a href="#">
								<!--备注：第一张图 宽度：418像素，高度：710像素-->
								<div class="tu clearfix">
									<img src="${TJ[0].pic}"/>
									<span></span>
								</div>
								<div class="listxia clearfix ta-center">
									<h2>
										<p>
											${TJ[0].title}
											<span>${TJ[0].price/100}</span>
										</p>
									</h2>
								</div>
							</a>
						</div>
						<div class="listone listtwo clearfix fl">
							<a href="#">
								<!--备注：第二张图 宽度：438像素，高度：376像素-->
								<div class="tu clearfix">
									<img src="${TJ[1].pic}"/>
									<span></span>
								</div>
								<div class="listxia clearfix ta-center">
									<h2>
										<p>
											${TJ[1].title}
											<span>${TJ[1].price/100 }</span>
										</p>
									</h2>
								</div>
							</a>
						</div>
					</div>
					<div class="right clearfix fr">
						<div class="listone listthree clearfix fl">
							<a href="#">
								<!--备注：第三张图 宽度：530像素，高度：638像素-->
								<div class="tu clearfix">
									<img src="${TJ[2].pic }"/>
									<span></span>
								</div>
								<div class="listxia clearfix ta-center">
									<h2>
										<p>
											${TJ[2].title }
											<span>${TJ[2].price/100 }</span>
										</p>
									</h2>
								</div>
							</a>
						</div>
						
						<div class="listone listfour clearfix fr">
							<a href="#">
								<!--备注：第四张图 宽度：438像素，高度：480像素-->
								<div class="tu clearfix">
									<img src="${TJ[3].pic }"/>
									<span></span>
								</div>
								<div class="listxia clearfix ta-center">
									<h2>
										<p>
											${TJ[3].title }
											<span>${TJ[3].price/100 }</span>
										</p>
									</h2>
								</div>
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
		<!--recom end-->
		
		
		<!--choice star-->
		<div class="choice clearfix">
			<div class="bgdian"></div>
			<div class="recom-tit clearfix">
				<p class="engtit ta-center">
					SHOPPING MALL
				</p>
				<div class="middle clearfix">
					<span class="line"></span>
					<span class="wenzi">商城精选</span>
					<span class="line"></span>
				</div>
				<p class="fu-tit">
					画品丰富多类 抽象 印象 自然 城市皆有
				</p>
			</div>
			<div class="content clearfix box-s">
				<a href="#" class="choice-more">MORE+</a>
				<c:forEach items="${JX}" var="jx">
				<div class="list clearfix transition">
					<div class="tu clearfix">
						<img src="${jx.pic}"/>
						<span></span>
						
						<div class="ycang clearfix">
							<samp class="opa8"></samp>
							<div class="nr clearfix">
								<!--注意：当下方li中添加class名为cur的时候为选中的时候样式-->
								<ul>
									<li class="box-s transition">收藏</li>
									<li class="box-s transition">购物车</li>
								</ul>
							</div>								
						</div>
					</div>
					<div class="xia clearfix box-s">
						<p class="bt over">
							${jx.title}
						</p>
						<div class="price clearfix">
							<span class="fl">￥${jx.price/100}</span>
							<a href="pro_detail.html" class="goumai fr ra3 transition">立即购买</a>
						</div>
					</div>
				</div>
			</c:forEach>
			</div>
		</div>
		<!--choice end-->
		
		<!--art star-->
		<div class="art clearfix">
			<div class="content clearfix box-s">
				<div class="art-ctent clearfix box-s">
					<div class="recom-tit clearfix">
						<p class="engtit ta-center">
							ART WRITER
						</p>
						<div class="middle clearfix">
							<span class="line"></span>
							<span class="wenzi">艺术家</span>
							<span class="line"></span>
						</div>
					</div>
					<div class="bottom clearfix box-s">
						<div class="scrollBox" style="margin:0 auto">
							<div class="ohbox">
								<ul class="piclist">
								<c:forEach items="${ZJ}" var="zj">
									<li>
										<div class="list clearfix fl box-s transition">
											<div class="tu clearfix box-s">
												<img src="${zj.pic}"/>
												<span></span>
											</div>
											<div class="ctent clearfix box-s">
												<div class="shang clearfix">
													<p class="over ta-center">${zj.title}</p>
													<span></span>
												</div>
												<div class="xia clearfix">
													<p>
														${zj.content}
														<a href="${zj.url}" class="more">
															查看更多&gt;&gt;
														</a>
													</p>
												</div>
											</div>
										</div>
									</li>
						       </c:forEach>
								</ul>
							</div>
							<div class="pageBtn">
								<span class="prev">&lt;</span>
								<span class="next">&gt;</span>
								<ul class="list"><li>0</li><li>1</li></ul>
							</div>
						</div>
					</div>		
					
				</div>
			</div>
		</div>
		<!--art end-->
		
		<!--footer star-->
		<div class="footer clearfix">
			<div class="content clearfix">
				<div class="top clearfix">
					<div class="list clearfix fl box-s">
						<div class="part icon1 box-s">
							<h3>专业</h3>
							<p>拥有资深艺术顾问和先进交易平台，安全物流，快捷支付。</p>
						</div>
					</div>
					<div class="list clearfix fl box-s">
						<div class="part icon2 box-s">
							<h3>保真</h3>
							<p>阵容强大的艺术评鉴团，确保平台上的藏品货真价实。</p>
						</div>
					</div>
					<div class="list clearfix fl box-s">
						<div class="part icon3 box-s">
							<h3>保值</h3>
							<p>为您精选具备艺术价值的作品，助您的资产保值、增值。</p>
						</div>
					</div>
				</div>
				<div class="bottom clearfix">
					<div class="left clearfix fl">
						<div class="list clearfix">
							<div class="shang clearfix">
								<p>新手指南</p>
								<span></span>
							</div>							
							<div class="xia clearfix">
								<ul>
									<li><a href="scgmlc.html">商城购买流程</a></li>
									<li><a href="cjwt.html">常见问题</a></li>
								</ul>
							</div>
						</div>
						<div class="list clearfix">
							<div class="shang clearfix">
								<p>账户管理</p>
								<span></span>
							</div>							
							<div class="xia clearfix">
								<ul>
									<li><a href="zhcz.html">账户充值</a></li>
									<li><a href="zhtx.html">账户提现</a></li>
									<li><a href="zffs.html">支付方式</a></li>
								</ul>
							</div>
						</div>						
						<div class="list clearfix">
							<div class="shang clearfix">
								<p>服务合作</p>
								<span></span>
							</div>							
							<div class="xia clearfix">
								<ul>
									<li><a href="friend-link.html">友情链接</a></li>
									<li><a href="ysjrz.html">艺术家入驻</a></li>
								</ul>
							</div>
						</div>
						<div class="list clearfix">
							<div class="shang clearfix">
								<p>关于我们</p>
								<span></span>
							</div>							
							<div class="xia clearfix">
								<ul>
									<li><a href="gsjj.html">公司简介</a></li>
									<li><a href="contact.html">联系我们</a></li>
									<li><a href="jrwm.html">加入我们</a></li>
								</ul>
							</div>
						</div>
						<div class="list clearfix">
							<div class="shang clearfix">
								<p>售后服务</p>
								<span></span>
							</div>							
							<div class="xia clearfix">
								<ul>
									<li><a href="wlsm.html">物流说明</a></li>
									<li><a href="mzsm.html">免责声明</a></li>
								</ul>
							</div>
						</div>
					</div>
					<div class="middle clearfix fl">
						<ul>
							<li><img src="upload/ewm.jpg"/></li>
							<li><img src="upload/ewm.jpg"/></li>
						</ul>
					</div>
					<div class="right clearfix fr">
						<p class="bt">免费咨询热线：</p>
						<p class="tel">400-000-0000</p>
						<p class="fu-bt">(周一到周五8:00-22:00)</p>
					</div>
				</div>
			</div>
			<div class="banquan clearfix ta-center">
				Copyright © 2003-2015 椿龄文化(chunlingwenhua). All Rights Reserved. 
			</div>
		</div>
		<!--footer end-->
	</body>
	<script src="js/other.js" type="text/javascript" ></script>
</html>
