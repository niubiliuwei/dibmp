loadFlag = false ;
$(function() {
	$("button[id^=storage-]").each(function(){
		$(this).on("click",function(){
			wiid = this.id.split("-")[1] ;
			console.log(wiid + "-=-=-=-");
			$.post("pages/back/admin/goods/getWarehouse.action",{"wiid":wiid},function(data){			
				
				if(data !="false"){
					 $("#daname").text(data.allWareHourse.name) ;
					 $("#pid").text(data.allProvince.title) ;
					 $("#cid").text(data.allCity.title) ;
					 $("#currnum").text(data.allWareHourse.currnum) ;
				$("#goodsRecordInfo").modal("toggle") ; 
				}
			},"json")
			
		}) ;
	}) ;
	$('#storageDetails').on('show.bs.collapse', function () {
		if (loadFlag == false) {
			// ajax异步加载库存信息
			operateAlert(true,"商品库存信息加载成功！","商品库存信息加载失败！") ;
			loadFlag = true ; // 数据已经加载完成
			$("span[id^=mid-]").each(function(){
				$(this).on("click",function(){
					mid = this.id.split("-")[1] ;
					$.post("pages/back/admin/goods/getMemberByLevelAndDept.action",{"mid":mid},function(data){			
						if(data !="false"){
							
							console.log("show yemian");
							console.log(data.allMember.name);
							$("#Membername").text(data.allMember.name) ;
							 $("#title").text(data.allLevel.title) ;
							 $("#dname").text(data.allDept.dname) ;
							 $("#phone").text(data.allMember.phone) ;
							 $("#note").text(data.allMember.note) ;
					$("#memberInfo").modal("toggle") ;
						}
					},"json")
				}) ;
			}) ;
		}
		}) ;
	
	
})