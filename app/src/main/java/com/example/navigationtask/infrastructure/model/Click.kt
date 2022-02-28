package com.example.navigationtask.infrastructure.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "click_table")
data class Click(
    @PrimaryKey(autoGenerate = true) val id: Int? = null,
    val buttonName: String?,
    val data: String?
    ) {
}