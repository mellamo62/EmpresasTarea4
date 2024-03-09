import {Component} from '@angular/core';
import {Empresa} from "../Empresa";
import * as L from "leaflet";
import {marker} from "leaflet";
import {EmpresaService} from "../services/empresa.service";
import {ReactiveFormsModule} from "@angular/forms";
import {MapService} from "../services/map.service";

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [
    ReactiveFormsModule
  ],
  templateUrl: './home.component.html',
  styleUrl: './home.component.css'
})
export class HomeComponent {

  empresas: Empresa[] = [];
  map: any;

  constructor(public empresaService: EmpresaService) {

  }

  ngOnInit(): void {
    this.empresaService.getAll().subscribe((data: Empresa[]) => {
      this.empresas = data;

    })
  }

  ngAfterViewInit() {
    setTimeout(() => {
      this.map = new L.Map('map').setView([36.7210131089889, -4.467530505087599], 12);

      L.tileLayer('https://tile.openstreetmap.org/{z}/{x}/{y}.png', {
        maxZoom: 16,
        minZoom: 11,
      }).addTo(this.map);



      for (let empresa of this.empresas) {
        marker([empresa.latitud, empresa.longitud]).addTo(this.map).bindPopup(`<a href="/details/${empresa.id}">${empresa.nombre}</a>`).openPopup();
      }

    }, 1000);
  }


}
