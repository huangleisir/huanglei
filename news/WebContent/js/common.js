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

// ��֤�Ƿ��ǿ�
function isNull(str)
{
    if(str.length==0)
        return true;
    else
        return false;
}
// ��֤�Ƿ�������С����
function minLength(str,length)
{
    if(str.length>=length)
        return true;
    else
        return false;
}
// �ж��Ƿ�������󳤶�
function maxLength(str,length)
{
    if(str.length<=length)
        return true;
    else
        return false;
}
// �ж��Ƿ�������
function isDigital(str)
{
    for(i=0;i<str.length;i++)
    {
        // ����ʹ�����ַ�
        if(str.charAt(i)>='0' && str.charAt(i)<='9' 
            || str.charAt(i)=="-" && i!=0 && i!=str.length-1)
            continue;
        else
            return false;
    }
    return true;
}
// �ж��Ƿ�������
function isNumber(str)
{
    for(i=0;i<str.length;i++)
    {
        // ���Ҫ�ж�С������Ҫ�ж�С����
        if(str.charAt(i)>='0' && str.charAt(i)<='9' 
            || str.charAt(i)=="-" && i==0)
            continue;
        else
            return false;
    }
    return true;
}
// �ж��Ƿ������ڣ����ڵĸ�ʽΪ1988-1-1
function isDate(date)
{
    // ���ҷָ���
    index1 = date.indexOf("-");
    // ����ָ��������ڣ����ǺϷ���ʱ��
    if(index1 == -1)
        return false;
    // ��ȡʱ���е���
    year = date.substring(0,index1);
    // ��ȡʱ���е�ʣ�²���
    date = date.substring(index1+1);
    // ���ҵڶ����ָ���
    index1 = date.indexOf("-");
    // ��������ڵڶ����ָ��������ǺϷ���ʱ��
    if(index1 == -1)
        return false;
    // ��ȡʱ���е��·�
    month = date.substring(0,index1);
    // ��ȡʱ���е���
    day = date.substring(index1+1);
    // �ж��Ƿ������֣�����������ǺϷ���ʱ��
    if(isNumber(year) && isNumber(month) && isNumber(day))
    {
        // �жϻ�����Χ
        if(year<1900 || year>9999 || month<1 || month >12 || day<1)
            return false;
        // �ж�31�����
        if((month==1 || month==3 || month==5 || month==7
        || month==8 || month==10 || month==12) && day>31)
            return false;
        // �ж�30�����
        if((month==4 || month==6 || month==9 || month==11)
            && day>30)
            return false;
        // �����2�£��ж��Ƿ�Ϊ����
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
// �ж��Ƿ���Email
function isEmail(email)
{
    if(email.length==0)
        return false;
    index1 = email.indexOf('@');
    index2 = email.indexOf('.');
    if(index1 < 1              // @���Ų����ڣ������ڵ�һ��λ��
    || index2 < 1          // .���Ų����ڣ������ڵ�һ��λ��
    || index2-index1 <2    // .��@����߻�������
    || index2+1 == email.length) // .���ź���û�ж���
        return false;
    else
        return true;
}
