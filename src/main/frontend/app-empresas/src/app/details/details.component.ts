import {Component, inject, OnInit} from '@angular/core';
import {ActivatedRoute} from "@angular/router";
import {EmpresaService} from "../services/empresa.service";
import {Empresa} from "../Empresa";
import {NgOptimizedImage} from "@angular/common";

@Component({
  selector: 'app-details',
  standalone: true,
  imports: [
    NgOptimizedImage
  ],
  templateUrl: './details.component.html',
  styleUrl: './details.component.css'
})
export class DetailsComponent implements OnInit {

  empresaId: number = 0;
  empresa:Empresa = {id:0,nombre:"VOID",descripcion:"VOID",direccion:"VOID",img:"VOID",latitud:0,longitud:0,fechaFundacion:"00/00/0000"};

  constructor(public empresaService: EmpresaService, private route: ActivatedRoute) {  }

  ngOnInit() {
    this.empresaId = this.route.snapshot.params['id'];
    this.empresaService.find(this.empresaId).subscribe((data:Empresa)=>{
      this.empresa = data;
    })
  }


}
