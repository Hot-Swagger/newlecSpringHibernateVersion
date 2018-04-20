


/*ex6. 노드 조작 예제*/
$(function () {
    var box = $('#ex6>div:nth-child(2)')
    var addButton = $('#ex6 .btn-add');
    var removeButton = $('#ex6 .btn-remove');
    addButton.click(function(){
        //1. text 노드 추가하기
        /*var node = document.createTextNode('Hello');
        box.append(text);*/
        /*
        var text = 'Hello';
        box.append(text);
        */

        //2. img 노드 추가하기
        /*
        $(img);         => Wrapping
        $("img");       => Selecting
        $("<img />");   => Creating
        */

        // 2-1. 방법1
        /*var img = $("<img />")
                    .attr("src","images/acorn.png");
        box.append(img);*/

        // 2-2. jQuery스러운 방법2
        var img = $("<img />")
                    .attr("src","images/acorn.png")
                    .appendTo(box);

        //3. 복합 노드(<span>text</span>) 추가하기

    });

    removeButton.click(function(){
        
    });
});

/*ex5. ?? 예제*/
$(function () {
    var img1 = $('#ex5 img:nth-child(1)');
    var img2 = $('#ex5 img:nth-child(2)');
    var img3 = $('#ex5 img:nth-child(3)');
    var okButton = $('#ex5 .btn-ok');
    var cssButton = $('#ex5 .btn-css');
    okButton.click(function(){

    });

    cssButton.click(function(){
        
    });
});

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
	var img1 = $('#ex4 img:first-child');
	var img2 = $('#ex4 img:last-child');
    var okButton = $('#ex4 .btn-ok');
    var cssButton = $('#ex4 .btn-css');
    okButton.click(function(){

        // 1. css 변화에 duration을 주기
    	/*
    	var imgStyle = {
        	width:"300px",
        	height:"100px",
        	boxShadow:"#979797 3px 3px 3px"
        };
        img1.animate(imgStyle, 3000); // img.animate(imgStyle);
        */
    	
        // 2. css 변화에 순서를 주고 싶을 때
        /*img1
        .animate({
            width:"300px"
        })
        .animate({
            height:"100px"
        });*/
    	/*
    	img2
		.delay(800)	//	800 딜레이 후에 변형
		.animate({
			width:"200px",
			height:"100px"
		});*/
    	
    	img1.animate({	//	함수안에 함수
			width:"200px"
		},function(){
			img2
			.animate({
				width:"200px",
				height:"200px"
			});	
		})
		.animate({
			height:"200px"
		},2000);
    });

    cssButton.click(function(){
    	/*
    	img1
		.css({
			width:"300px"
		})
		.css({
			height:"200px"
        });*/
        /*
    	img2.removeClass("animate")
    	setTimeout(function(){    		
    		img2.addClass("animate");
    	},100);*/
        
        img2.on("animationend",function(){
            img2.removeClass("animate");
        });
        img2.addClass("animate");
    });
});
