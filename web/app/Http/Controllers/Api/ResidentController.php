<?php

namespace App\Http\Controllers\Api;

use App\Department;
use App\Http\Controllers\Controller;
use App\Http\Requests\ResidentRequest;
use App\Http\Resources\RecordResource;
use App\Http\Resources\ResidentResource;
use App\Http\Resources\VisitResource;
use App\Record;
use App\Resident;
use App\Visit;
use Symfony\Component\HttpKernel\Exception\HttpException;
use Illuminate\Database\Eloquent\Collection;

class ResidentController extends Controller
{
    /**
     * Display a listing of the resource.
     *
     * @return \Illuminate\Http\Response
     */
    public function index()
    {
        try{
            $residents = Resident::all();
            $data = response(ResidentResource::collection($residents));
        }
        catch(HttpException $error){
            $data = $error->getMessage();
        }
        return $data;
    }

    /**
     * Store a newly created resource in storage.
     *
     * @param  $request
     * @return \Illuminate\Http\Response
     */
    public function store(ResidentRequest $request)
    {
       $department_number = $request->department_number;
       $department = Department::all()
           ->where('number', $department_number)->first();

        // If the department number exists in the database.
        if ($department != null) {
            $department_id = $department->id;
            $request->request->add(['department_id' => $department_id]);
            $data = $request->except(['department_number']);
            $resident = Resident::create($data);
        }else{
            return response([
                'message' => "The indicated department doesn't exist"
                            ]);
        }

       return response([
            'message' => 'Created Successfully',
            'resident' => new ResidentResource($resident),
        ],  201);
    }

    /**
     * Display the specified resource.
     *
     * @param String $search
     * @param String $option
     * @return \Illuminate\Http\Response
     */
    public function show($search, $option = null)
    {
        if ($option == null)
        {
            $residents = Resident::all()->where('rut', $search);
        }
        elseif ($option == "department")
        {
            $department = Department::all()->where('number', $search)->first();
            $residents = Resident::all()->where('department_id', $search);
        }
        elseif ($option == "visit")
        {
            $visit = Visit::all()->where('rut', $search)->first();
            $records = Record::all()->where('visit_id', $visit->id);
            $residents = new Collection();
            foreach ($records as $record)
            {
                $resident = Resident::all()->where('id', $record->resident_id);
                if (!$residents.contains($resident))
                {
                    $residents->add($resident);
                }
            }
        }else{
            return response(
                ["message", "invalid route"]
            );
        }
        return response(
            ResidentResource::collection($residents)
        );
    }

    /**
     * Update the specified resource in storage.
     *
     * @param  \Illuminate\Http\Request  $request
     * @param  \App\Resident  $resident
     * @return \Illuminate\Http\Response
     */
    public function update(ResidentRequest $request, Resident $resident)
    {
        $resident->update($request->all());

        return response([
            'message' => 'Updated Successfully',
            'resident' => new ResidentResource($resident),
        ], 200);

    }

    /**
     * Remove the specified resource from storage.
     *
     * @param  \App\Resident  $resident
     * @return \Illuminate\Http\Response
     */
    public function destroy(Resident $resident)
    {
        $resident->delete();
        return response([
           'message' => 'Resident Deleted',
        ]);

    }
}
