var util = {
	SUCCESS : 0,
	ERROR : 1,
	NEED_LOGIN : 2,
	ILLEGAL_PERMISSION : 3,
	isNull : function(value){
		if(value == '' || value == undefined || value == null) {
			return true;
		}
	}
}