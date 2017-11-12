$(function(){
	$("button[id^=out-]").each(function(){
		$(this).on("click",function(){
			cid = this.id.split("-")[1] ;
			
				operateAlert(true,"待出库商品添加成功！","待出库商品添加失败！") ;
				
		}) ;
	}) ;
	$("span[id^=storage-]").each(function(){
		$(this).on("click",function(){
			wiid = this.id.split("-")[1] ;
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
	});
	$("span[id^=mid-]").each(function(){
		$(this).on("click",function(){
			mid = this.id.substring(this.id.indexOf("-")+1,this.id.length) ;
			console.log(this.id);
			console.log(mid);
			
			
			$.post("pages/back/admin/goods/getMemberByLevelAndDept.action",{"mid":mid},function(data){			
				if(data !="false"){
					
					$("#Membername").text(data.allMember.name) ;
					$("#title").text(data.allLevel.title) ;
					$("#dname").text(data.allDept.dname) ;
					$("#phone").text(data.allMember.phone) ;
					$("#note").text(data.allMember.note) ;
					$("#memberInfo").modal("toggle") ;
				}
			},"json")
					
				
	}) ;
});
})
