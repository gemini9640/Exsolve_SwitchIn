<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<script>
$.JsUtil = {
	fmtDateTime : function (format, val) {
		if (val != null) {
		    var date = new Date(val);
		    var month = (date.getMonth() + 1);
		    var day = date.getDate();
		    var year = date.getFullYear();
		    var hour = date.getHours();
		    var min = date.getMinutes();
		    var sec = date.getSeconds();
		    
		    var formator = format.toLowerCase();
			if(formator == "mm/dd/yyyy hh:mm:ss") {
			    return month + '/' + day + "/" + year + " " + hour + ":" + min + ":" + sec;
		    } else if(formator == "mm/dd/yyyy") {
		    	return month + '/' + day + "/" + year;
		    } else {
		    	return "";
		    }
		}
	},
	convertDate : function(date) {
		var date = new Date(date);
	    var year = date.getFullYear();
	    var month = date.getMonth()+1;
	    var day = date.getDate();
        month = month<10?0+""+month:month;
        day = day<10?0+""+day:day;
	    return day+"-"+month+"-"+year;
	},
	convertDateTime : function(date) {
		var date = new Date(date);
	    var hour = date.getHours();
        var min = date.getMinutes();
        var sec = date.getSeconds();
        
        hour = hour<10?0+""+hour:hour;
        min = min<10?0+""+min:min;
        sec = sec<10?0+""+sec:sec;
	    return $.JsUtil.convertDate(date)+" "+hour+":"+min+":"+sec;
	},
	undefinedRed : function (selector) {
		$(selector).each(function() {
			if($(this).text() == "undefined") {
				$(this).addClass("red");
			}
		});
	}
}
</script>