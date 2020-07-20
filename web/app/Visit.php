<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Visit extends Model
{
    protected $fillable = [
        'name', 'rut', 'admitted'
    ];
    public function records(){
        return $this->hasMany('App\Record');
    }
}
