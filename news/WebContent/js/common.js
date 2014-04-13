//function name:fucCheckNUM
function fucCheckNUM(NUM){
	var i,j,strTemp;
	strTemp="0123456789";
	if ( NUM.length== 0)
		return false;

	for (i=0;i<NUM.length;i++){
		j=strTemp.indexOf(NUM.charAt(i)); 
		if (j==-1){
			return false;
		}
	}
	return true;
}

//function name:chkemail
function chkemail(a){
	if(a==''){
		return false;
	}
	var i=a.length;
	var temp = a.indexOf('@');
	var tempd = a.indexOf('.');
	if (temp > 1) {
		if ((i-temp) > 3){
   
			if ((i-tempd)>0){
				return true;
			}   
		}
	}
	return false;
}

//function name:chkmobile
function chkmobile(mobile){
	//alert(mobile);
	if(mobile==''){
		return false;
	}
	var reg = /^(13|15|18){1}[0-9]{9}$/;
	if(reg.exec(mobile)){
		return true;
	}
	return false;
}

function chkDate(date) { 
	var yyyy = date.substring(0,4);
	var mm = date.substring(4,6);
	var dd = date.substring(6);
	var aa = new Date(parseInt(yyyy,10), parseInt(mm,10)-1, parseInt(dd,10) ); 

	if (aa.getMonth() != (parseInt(mm,10)-1)){ 
		//alert("date error"); 
		return false; 
	}else{ 
		//alert("ok"); 
		return true; 
	}
}

// 验证是否是空
function isNull(str)
{
    if(str.length==0)
        return true;
    else
        return false;
}
// 验证是否满足最小长度
function minLength(str,length)
{
    if(str.length>=length)
        return true;
    else
        return false;
}
// 判断是否满足最大长度
function maxLength(str,length)
{
    if(str.length<=length)
        return true;
    else
        return false;
}
// 判断是否是数字
function isDigital(str)
{
    for(i=0;i<str.length;i++)
    {
        // 允许使用连字符
        if(str.charAt(i)>='0' && str.charAt(i)<='9' 
            || str.charAt(i)=="-" && i!=0 && i!=str.length-1)
            continue;
        else
            return false;
    }
    return true;
}
// 判断是否是整数
function isNumber(str)
{
    for(i=0;i<str.length;i++)
    {
        // 如果要判断小数，需要判断小数点
        if(str.charAt(i)>='0' && str.charAt(i)<='9' 
            || str.charAt(i)=="-" && i==0)
            continue;
        else
            return false;
    }
    return true;
}
// 判断是否是日期，日期的格式为1988-1-1
function isDate(date)
{
    // 查找分隔符
    index1 = date.indexOf("-");
    // 如果分隔符不存在，则不是合法的时间
    if(index1 == -1)
        return false;
    // 获取时间中的年
    year = date.substring(0,index1);
    // 获取时间中的剩下部分
    date = date.substring(index1+1);
    // 查找第二个分隔符
    index1 = date.indexOf("-");
    // 如果不存在第二个分隔符，则不是合法的时间
    if(index1 == -1)
        return false;
    // 获取时间中的月份
    month = date.substring(0,index1);
    // 获取时间中的日
    day = date.substring(index1+1);
    // 判断是否是数字，如果不是则不是合法的时间
    if(isNumber(year) && isNumber(month) && isNumber(day))
    {
        // 判断基本范围
        if(year<1900 || year>9999 || month<1 || month >12 || day<1)
            return false;
        // 判断31天的月
        if((month==1 || month==3 || month==5 || month==7
        || month==8 || month==10 || month==12) && day>31)
            return false;
        // 判断30天的月
        if((month==4 || month==6 || month==9 || month==11)
            && day>30)
            return false;
        // 如果是2月，判断是否为润年
        if(month==2)
        {
            if(year%400==0 || (year%4==0 && year%100!=0))
            {
                if(day>29)
                    return false;
            }else
            {
                if(day>28)
                    return false;
            }
        }
    }
    else
        return false;
    return true;
}
// 判断是否是Email
function isEmail(email)
{
    if(email.length==0)
        return false;
    index1 = email.indexOf('@');
    index2 = email.indexOf('.');
    if(index1 < 1              // @符号不存在，或者在第一个位置
    || index2 < 1          // .符号不存在，或者在第一个位置
    || index2-index1 <2    // .在@的左边或者相邻
    || index2+1 == email.length) // .符号后面没有东西
        return false;
    else
        return true;
}
