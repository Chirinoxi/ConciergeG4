<?php

namespace App\Http\Requests;

use App\Rules\isRutValid;
use Illuminate\Foundation\Http\FormRequest;

class VisitRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     *
     * @return bool
     */
    public function authorize()
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array
     */
    public function rules()
    {
        return [
            'name' => 'required|max:255',
            'rut' => ['required','max:50', new isRutValid(),'unique:visits'],
            'admitted' => 'in:yes,no,Yes,No'
        ];
    }

    public function messages()
    {
        return [
            'rut.required' => 'The :attribute it is required',
            'name.required' => 'Must entered the :attribute',
        ];
    }

}
