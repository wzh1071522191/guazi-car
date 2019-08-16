<table id="data" title="��Ϣ" class="easyui-datagrid"
		url="<%=request.getContextPath() %>/querySmoke.do" toolbar="#ToolBar" pagination="true" pageList="[2,5,10]"
		fitColumns="true" fit="true" rownumbers="true">
		<thead>
			<tr>
				<th data-options="field:'sid',width:100">���</th>
				<th data-options="field:'sname',width:100">Ʒ��</th>
                 <th data-options="field:'tname',width:100">����</th>
				<th data-options="field:'tar',width:100,formatter:formattar">������</th>
				<th data-options="field:'status',width:100,formatter:formatstatus">״̬</th>
				<th data-options="field:'qwe',width:100,formatter:formatcaozuo">����</th>
				
			</tr>
		</thead>
	</table>
	<div id="ToolBar">
		
		?Ʒ�ƣ�?<input type="text" id="bname" />
		����<select id="smoketype" style="width:70px"></select>
            <a id="searchBtn" class="easyui-linkbutton" class="easyui-linkbutton"
                iconCls="icon-search" plain="true">����</a>
            <br>����ֵ��<div id="p" style="width:400px;"></div> 
	</div>

<%-- 	<script type="text/javascript" src="<%=request.getContextPath() %>/js/MyEasyUIjs.js"></script> --%>
</body>
<script type="text/javascript">
$(function(){
	//queryuser();
	//selecttype();
	
	
	//����
	$("#searchBtn").click(function(){
		var name=$("#bname").val();//���ƣ��ı���
		var typeid = $("#smoketype").combobox('getValue');//���ͣ���̬ ������
		$("#data").datagrid('load',{
			sname:name,
			tid:typeid,
		})
	})

})
function formattar(value,row,index){
	return value+'mg';
}
function formatstatus(value,row,index){
	var a=value==1?'��������':'��ֹ����';
	return a;
}
function formatcaozuo(value,row,index){
	var str="";
	
	
	var yikoul=row.tar*0.01*0.1
	var liangkoul=row.tar*0.02*0.1
	var yikou='<a href="javascript:xiyan('+yikoul+')">��һ��</a>ح';
	var liangkou='<a href="javascript:xiyan('+liangkoul+')">������</a>ح';
	
	var z=row.status==1?'��ֹ����':'��ʼ����';
	var status=row.status==1?'2':'1';
	var ceshi='<a href="javascript:ceshi('+row.sid+','+status+')">'+z+'</a>';
	
	str+=yikou;
	str+=liangkou;
	str+=ceshi;
	return str;
}


//������
function queryuser(){
	$.ajax({
		url:"./queryuser.do",
		success:function(data){
			for (var i = 0; i < data.length; i++) {
				//������
				$('#p').progressbar({
					value: data[i].life
				}); 
			}
		},
		error:function(){}
	})
}

function selecttype(){
	$("#smoketype").combobox({
		url:'./queryType.do',
		valueField:'tid',
		textField:'tname',
	});
}




function xiyan(zhi){
	$.ajax({
		url:"./updateUser.do",
		type:"post",
		data:{"zhi":zhi},
		success:function(data){
			if(data){
				queryuser();
			}
		},
		error:function(){}
	})
}

function ceshi(id,status){
	$.ajax({
		url:"./updateSmoke.do",
		type:"post",
		data:{"id":id,"status":status},
		success:function(data){
			if(data){
				$("#data").datagrid('reload');
			}
			
		},
		error:function(){}
	})
}

</script>