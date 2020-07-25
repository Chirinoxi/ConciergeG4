<?php

namespace App\Http\Resources;

use Illuminate\Http\Resources\Json\JsonResource;

class RecordResource extends JsonResource
{
    /**
     * Transform the resource into an array.
     *
     * @param  \Illuminate\Http\Request  $request
     * @return array
     */
    public function toArray($request)
    {
        return [
            'kinship' => $this->kinship,
            'entryDate' => $this->entryDate,
            'departureDate' => $this->departureDate,
            'comment' => $this->comment,
            'resident' => $this->resident->name,
            'visits' => $this->visit->name,
            'department' => $this->department->number,
        ];
    }
}
