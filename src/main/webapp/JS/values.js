const d = document;

export function valueCheck(checkboxID) {
   let elemento = d.getElementById(checkboxID);
   if (!elemento) {
      console.error("No se encontró el checkbox");
      return;
   }
   elemento.addEventListener('change', (e) => {
      elemento.value = e.target.checked ? true : false;
   })
}

export function cerrarModal(btm, modal) {
    let btmCerrar = d.getElementById(btm);
    let section = d.getElementById(modal);

    if (!btmCerrar || !section) {
        console.error("No se encontró el boton o la sección objetivo.");
        return;
    }

    d.addEventListener("click", (e) => {
        if (e.target === btmCerrar) {
            section.style.display = "none";
        }
    });
}

export function LlenarInputEncargadoT() {
    const selectFondo = document.getElementById("select-fondo-T");
    const nombreEncargado = document.getElementById("nombre-en-t");
    const apellidoEncargado = document.getElementById("apellido-en-t");
    const dniEncargado = document.getElementById("dni-en-t");

    selectFondo.addEventListener("change", function() {
        const selectedOption = selectFondo.options[selectFondo.selectedIndex];
        const nombre = selectedOption.getAttribute("data-encargado-nombre");
        const apellido = selectedOption.getAttribute("data-encargado-apellido");
        const dni = selectedOption.getAttribute("data-encargado-dni");

        if (nombre && apellido && dni) {
            nombreEncargado.value = nombre;
            apellidoEncargado.value = apellido;
            dniEncargado.value = dni;
        } else {
            nombreEncargado.value = "";
            apellidoEncargado.value = "";
            dniEncargado.value = "";
        }
    });
}



