<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Record extends Model
{
    protected $fillable = [
        "visit_rut", "department_number", "type", "kinship", "entryDate", "departureDate", "comment", 'resident_id', 'visit_id', 'department_id'
    ];

    protected $hidden = [
        'id'
    ];
protected $table = 'records';
    public function resident()
    {
        return $this->belongsTo('App\Resident','resident_id');
    }

    public function visit()
    {
        return $this->belongsTo('App\Visit','visit_id');
    }

    public function department()
    {
        return $this->belongsTo('App\Department', 'department_id');
    }

}
