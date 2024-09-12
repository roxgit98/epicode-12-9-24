package davidegiliberti.epicode_12_9_24.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoLetturaMinuti;
    @ManyToOne
    @JoinColumn(name = "autore_id", nullable = false)
    private Autore autore;

    public Blog() {
    }

    public Blog(String categoria, String titolo, String cover, String contenuto, int tempoLetturaMinuti) {
        this.categoria = categoria;
        this.titolo = titolo;
        this.cover = cover;
        this.contenuto = contenuto;
        this.tempoLetturaMinuti = tempoLetturaMinuti;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTitolo() {
        return titolo;
    }

    public void setTitolo(String titolo) {
        this.titolo = titolo;
    }

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getContenuto() {
        return contenuto;
    }

    public void setContenuto(String contenuto) {
        this.contenuto = contenuto;
    }

    public int getTempoLetturaMinuti() {
        return tempoLetturaMinuti;
    }

    public void setTempoLetturaMinuti(int tempoLetturaMinuti) {
        this.tempoLetturaMinuti = tempoLetturaMinuti;
    }

    public Autore getAutore() {
        return autore;
    }

    public void setAutore(Autore autore) {
        this.autore = autore;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", categoria='" + categoria + '\'' +
                ", titolo='" + titolo + '\'' +
                ", cover='" + cover + '\'' +
                ", contenuto='" + contenuto + '\'' +
                ", tempoLetturaMinuti=" + tempoLetturaMinuti +
                '}';
    }
}
