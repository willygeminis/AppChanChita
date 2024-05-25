import { navegar, normal } from "./navegavilidad.js";
import {valueCheck,cerrarModal,LlenarInputEncargadoT} from "./values.js";

const d = document;
const w = window;

d.addEventListener("DOMContentLoaded", (e) => {
    navegar(".sec", ".iniciooo", "s-inicio");
    navegar(".sec", ".fondooo", "s-fondo");
    navegar(".sec", ".tranferenciaaa", "s-transaccion");
    navegar(".sec", ".manual", "s-manual");
    valueCheck("f-notificacion")
    cerrarModal("cerrar-modal-error", "s-error");
    LlenarInputEncargadoT();
    normal();
});
