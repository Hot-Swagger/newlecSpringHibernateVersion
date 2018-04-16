/*ex0. 초기화 블록*/
//window.addEventListener("load", function () { });

$(function () {
    //alert('a');
});

/*ex1. 노드선택*/
$(function () {
    //var okButton = document.querySelector("#ex1 .btn-default");
    var okButton = $('#ex1 .btn-default');
    okButton.val('ㅎㅎ');
});

/*ex2. 이벤트 처리하기*/
$(function () {
    var okButton = $('#ex2 .btn-default');
    /*onButton.onclick = ?;
    onButton.addEventListener("click",?)*/
    
    okButton.on("click",function(){
    	alert("호호호");
    });
    
    okButton.click(function(){
    	alert("하하하");
    });
});

/*ex3. 속성과 스타일 수정하기*/
$(function () {
	
    var okButton = $('#ex3 .btn-ok');
    var img = $('#ex3 img');
    var textBox = $('#ex3 input[type=text]');
   
    okButton.click(function () {
    	// 이미지 변경 src
    	//var imgName = textBox.attr('value') (x)
        var imgName = textBox.val();
        img.attr('src', 'images/' + imgName);
        
        // 3. 개별적으로 스타일 지정하기
        /*img.css("width", "300px");
        img.css("height", "100px");
        img.css("box-shadow", "#979797 3px 3px 3px");*/
        
        // 4. 하나로 묶어서 스타일 지정하기
        /*var imgStyle = {
        	width:"300px",
        	height:"100px",
        	boxShadow:"#979797 3px 3px 3px"
        };
        img.css(imgStyle);*/
        
        // 5. 정적인 스타일은 CSS(.zomm-in)로 준비하고 적용하기
        img.addClass("zoom-in");
    });

    var toggleButton = $('#ex3 .btn-toggle');
    toggleButton.click(function(){
        if(img.hasClass("zoom-in"))
        	img.removeClass('zoom-in');
        else
            img.addClass('zoom-in');
    })
});

/*ex4. 효과주기*/
$(function () {
	var img = $('#ex4 img');
    var okButton = $('#ex4 .btn-ok');
    var toggleButton = $('#ex4 .btn-toggle');
    okButton.click(function(){

        // 1. css 변화에 duration을 주기
        var imgStyle = {
        	width:"300px",
        	height:"100px",
        	boxShadow:"#979797 3px 3px 3px"
        };
        //img.animate(imgStyle);
        img.animate(imgStyle, 3000);
    });

    toggleButton.click(function(){
        // 2. css 변화에 순서를 주고 싶을 때
        img
        .animate({
            width:"300px"
        })
        .animate({
            height:"100px"
        });
    });
});