import React, { useState } from "react";
// import {a, b} from './data';
import {person, company} from "./data";

export default function main(){
    // let[상품, 상품수정] = useState(a);
    // let[상품2, 상품수정2] = useState(b);

    return(
        <div>Main
            <h1>{person.name}</h1>
            <p>나이 : {person.age}</p>
            <p>나이 : {person.job}</p>

            <h1>{company.name}</h1>
            <p>위치 : {company.location}</p>
        </div>

        
    );
}