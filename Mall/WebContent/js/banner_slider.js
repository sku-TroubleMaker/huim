//��� �ϳ��� ũ��
var BANNER_WIDTH = 600;
var SHOW_DURATION = 500;
var AUTO_PLAY_TIME = 5000;

//�츮�� �����̰� �� ��� ������ ������Ʈ
var $banner_content;
// ��� ��ü ����
var nBannerLength = 0;
// ���� ȭ�鿡 ���̴� ����� �ε���
var nCurrentBannerIndex = 0;

var $banner_dots;

var autoTimerID;


$(document).ready(function(){
	initMenu();
	initEventListener();
	
	startAutoPlay();
});	

	function initMenu() {		
		//��� ������ ������ ũ�⸦ �������� �ø���.
		$banner_content = $("#banner_content");
		nBannerLength = $banner_content.children("img").length;
		
		//��� �������� �ʺ� ��� �ϳ��� ũ�� * ��� ������ ������ ����
		$banner_content.width(BANNER_WIDTH * nBannerLength);
		
		//��� �޴��� ��ġ�� ǥ���� ������Ʈ�� ��� ����
		$banner_dots = $("#banner_nav li a");
		
		//��� �޴��� ��ġ�� 0��° �ʱ�ȭ
		showBannerDotAt(0);
		
		//autoPlay�� Ÿ�̹� ID��
		autoTimerID = 0;
	}
	
	function initEventListener() {
		//���� ��� ���̱�
		$("#btn_prev_banner").bind("click", function(){
			prevBanner();
		});
		
		//���� ��� ���̱�
		$("#btn_next_banner").bind("click", function(){
			nextBanner();
		});
		
		$banner_dots.bind("mouseenter", function(){
			var nIndex = $banner_dots.index(this);
			showBannerAt(nIndex);
		});
		
		var $banner_slider = $("div.banner_slider");
		$banner_slider.bind("mouseenter", function(){
			stopAutoPlay();
		});
		
		$banner_slider.bind("mouseleave", function(){
			startAutoPlay();
		});
	}
	
	function prevBanner(){
		// �̵��� ���� ��� �ε��� ���ϱ�
		var nIndex = nCurrentBannerIndex-1;
		
		// ������ ������ ��ʰ� ��� ��� ������ ����� �ε��� ������ ����
		if (nIndex<0) 
			nIndex = nBannerLength-1;
		
		//n��° ��� ���̱�
		showBannerAt(nIndex);
	}
	
	function nextBanner(){
		var nIndex = nCurrentBannerIndex+1;
		
		//���� ������ ��� ���, ù ��° ��� �ε��� ������ �����ϱ�
		if (nIndex>=nBannerLength)
			nIndex = 0;
		
		//n��° ��� ���̱�
		showBannerAt(nIndex);
	}
	
	
	//nIndex�� �ش��ϴ� ��� ���̱�
	function showBannerAt(nIndex) {
		if(nIndex != nCurrentBannerIndex) {
			//n��° ��� ��ġ�� ���ϱ�
			var nPosition = -BANNER_WIDTH * nIndex;
			
			showBannerDotAt(nIndex);
			
			//�����̵� ȿ�� ����
			$banner_content.stop();
			$banner_content.animate({left:nPosition}, SHOW_DURATION, "easeOutQuint");
			
			//���� ��� �ε��� ������Ʈ
			nCurrentBannerIndex = nIndex;			
		}
	}

	function showBannerDotAt(nIndex) {
		$banner_dots.eq(nCurrentBannerIndex).removeClass("select");
		$banner_dots.eq(nIndex).addClass("select");
	}
	
	function startAutoPlay() {
		if(autoTimerID!=0)
			clearInterval(autoTimerID);
			
		autoTimerID = setInterval(function(){nextBanner();}, AUTO_PLAY_TIME);
	}
		
	function stopAutoPlay(){
		if(autoTimerID!=0)
			clearInterval(autoTimerID);
			
			autoTimerID = 0;
	}
	