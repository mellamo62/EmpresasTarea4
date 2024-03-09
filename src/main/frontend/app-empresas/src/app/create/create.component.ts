import { Component } from '@angular/core';
import {FormControl, FormGroup, ReactiveFormsModule, Validators} from "@angular/forms";
import {EmpresaService} from "../services/empresa.service";
import {NgIf} from "@angular/common";
import { Router} from "@angular/router";

@Component({
  selector: 'app-create',
  standalone: true,
  imports: [
    ReactiveFormsModule,
    NgIf
  ],
  templateUrl: './create.component.html',
  styleUrl: './create.component.css'
})
export class CreateComponent {


  constructor(public empresaService:EmpresaService,private route:Router) {
  }


  createEmpresa:FormGroup = new FormGroup({
    nombre: new FormControl('',[Validators.maxLength(30),Validators.required, Validators.minLength(5)]),
    descripcion: new FormControl('',[Validators.required,Validators.minLength(5)]),
    direccion: new FormControl('',[Validators.required,Validators.maxLength(25),Validators.minLength(5)]),
    img: new FormControl('',[Validators.required,Validators.minLength(5)]),
    latitud: new FormControl('',[Validators.required,Validators.min(-90),Validators.max(90)]),
    longitud: new FormControl('',[Validators.required,Validators.min(-180),Validators.max(180)]),
    fechaFundacion: new FormControl('',Validators.required)
  })



  submit(){
    this.empresaService.create(this.createEmpresa.value).subscribe(res =>{
      console.log("Empresa creada: "+res)
    });

    alert("¡Empresa creada correctamente!");

    this.route.navigate(['/']);
  }
}
