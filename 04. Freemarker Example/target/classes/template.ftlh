Hello,${user.name}, your id is ${user.id},

<#if user.age??>
    Age is ${user.age}
<#else>
    Age is undefined
</#if>

Other users:

<#list users as userList>
    Name: ${userList.name}
    Age: ${userList.age}
</#list>