import request from '@/utils/request'

export default{
    //讲师列表，条件查询分页
    // 参数：当前页，每页记录数，条件对象
    getTeacherListPage(current,limit,teacherQuery){
        return request({
            // url: '/table/list',
            url:`/eduservice/teacher/pageTeacherCondition/${current}/${limit}`,
            method: 'post',
            data:teacherQuery
          })
    },
    deleteTeacherId(id){
        return request({
            url:`/eduservice/teacher/${id}`,
            method: 'delete'
          })
    },
    //添加讲师
    addTeacher(teacher){
        return request({
            url:`/eduservcie/teacher/addTeacher`,
            method: 'post',
            data:teacher
          })
    },
    getTeacherInfo(id){
        return request({
            url:`/eduservice/teacher/getTeacher/${id}`,
            method: 'get' 
          })
    },
    //修改讲师
    updateTeacherInfo(teacher){
        return request({
            url:`/eduservice/teacher/updateTeacher`,
            method: 'post',
            data:teacher 
          })
    }
}