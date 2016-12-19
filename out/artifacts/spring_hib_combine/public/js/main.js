$(document).ready(function() {
	$("#top_nav a").on("click", topbar_onclick);
	var first_top_menu = init_topbar();
	console.log(first_top_menu);
	select_topbtn(first_top_menu);
	showsub(first_top_menu,true);
});
function topbar_onclick(btn) {
	var btn_id = btn.target.id;
	current_btn = btn_id;
	var a = showsub(btn_id,false);
	if(a!=null){
		window.location.href = a.attr("href");
	}
}
function init_topbar() {
	var btn_arr = {};
	var first_top_menu;
	$(".submenu li").each(function(i, menu) {
		if(!first_top_menu){
			first_top_menu = $(menu).attr('ref');
		}
		btn_arr[$(menu).attr('ref')] = 1;
	});
	$("#top_nav li").each(function(i, btn) {
		if (btn_arr[$(btn).children("a").attr('id')] == 1) {
			$(btn).show();
		} else {
			$(btn).hide();
		}
	});
	return first_top_menu;
}
function activeMenu(mid) {
	var menu = $("#" + mid);
	var ref = menu.attr('ref');
	showsub(ref,true);
	menu.attr("class", "active");
	select_topbtn(ref);
}
function select_topbtn(btn_id){
	$("#top_nav li").each(function(i, obj) {
		var topbtn = $(obj);
		var t_id = topbtn.children("a").attr('id');
		if (btn_id == t_id) {
			topbtn.attr("class", "active");
		} else {
			topbtn.attr("class", "");
		}
	});
}
function showsub(btn_id,show){
	var first = null;
	$(".submenu li").each(function(index, menu) {
		if (btn_id != $(menu).attr('ref')) {
			if(show)
			$(menu).hide();
		} else {
			if(first==null)
				first = $(menu).children("a");
			if(show)
			$(menu).show();
		}
	});
	return first;
}