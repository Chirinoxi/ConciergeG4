<?php

namespace App\Http\Resources;

use Illuminate\Http\Resources\Json\JsonResource;

class ResidentResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return array
     */
    public function toArray($request)
    {
        return[
            'rut' => $this->rut,
            'name' => $this->name,
            'email' => $this->phone,
            'phone' => $this->phone,
            'department' => $this->department,
            'records' => RecordResource::collection($this->records)
        ];

    }
}
