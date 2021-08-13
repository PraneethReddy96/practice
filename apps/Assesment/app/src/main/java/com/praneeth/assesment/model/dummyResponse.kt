package com.praneeth.assesment.model

import com.google.gson.annotations.SerializedName

data class DataItem(

    @field:SerializedName("profile_image")
    val profileImage: String? = null,

    @field:SerializedName("employee_name")
    val employeeName: String? = null,

    @field:SerializedName("employee_salary")
    val employeeSalary: Int? = null,

    @field:SerializedName("id")
    val id: Int? = null,

    @field:SerializedName("employee_age")
    val employeeAge: Int? = null
)

data class DummyResponse(

    @field:SerializedName("data")
    val data: List<DataItem?>? = null,

    @field:SerializedName("message")
    val message: String? = null,

    @field:SerializedName("status")
    val status: String? = null
)
