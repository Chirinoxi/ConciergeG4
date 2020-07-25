<?php

namespace App;

use Illuminate\Database\Eloquent\Model;

class Visit extends Model
{
    protected $fillable = [
        'id', 'name', 'rut', 'admitted'
    ];
    protected $table = 'visits';

    public function records(){
        return $this->hasMany('App\Record');
    }
}
