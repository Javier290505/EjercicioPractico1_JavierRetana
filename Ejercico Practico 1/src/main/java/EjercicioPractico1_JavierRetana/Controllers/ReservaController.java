/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package EjercicioPractico1_JavierRetana.Controllers;

/**
 *
 * @author jareg
 */

import com.salonbelleza.salonbelleza.domain.Reserva;
import com.salonbelleza.salonbelleza.domain.Servicio;
import com.salonbelleza.salonbelleza.service.ReservaService;
import com.salonbelleza.salonbelleza.service.ServicioService;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/reservas")
public class ReservaController {

    private final ReservaServicio reservaService;
    private final ServicioServicio servicioServicio;

    public ReservaController(ReservaServicio reservaServicio, ServicioServicio servicioServicio) {
        this.reservaServicio = reservaServicio;
        this.servicioServicio = servicioServicio;
    }

    @GetMapping
    public String listar(Model model) {
        model.addAttribute("reservas", reservaServicio.listar());
        return "reservas/list";
    }

    @GetMapping("/nueva")
    public String nueva(Model model) {
        Reserva r = new Reserva();
        r.setFecha(LocalDate.now());

        model.addAttribute("reserva", r);
        model.addAttribute("servicios", servicioServicio.listar());
        model.addAttribute("servicioId", null);

        return "reservas/form";
    }

    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Reserva reserva,
                          @RequestParam("servicioId") Integer servicioId) {

        Servicio s = servicioServicio.buscarPorId(servicioId);
        reserva.setServicio(s);
        reservaServicio.guardar(reserva);

        return "redirect:/reservas";
    }

    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Integer id, Model model) {
        Reserva r = reservaServicio.buscarPorId(id);

        model.addAttribute("reserva", r);
        model.addAttribute("servicios", servicioServicio.listar());
        model.addAttribute("servicioId", r.getServicio() != null ? r.getServicio().getId() : null);

        return "reservas/form";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Integer id) {
        reservaServicio.eliminar(id);
        return "redirect:/reservas";
    }
}
