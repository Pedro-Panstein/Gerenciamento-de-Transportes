package com.weg.Gerenciamento_de_Transportes.repository.specs;

import com.weg.Gerenciamento_de_Transportes.model.Motorista;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
@NoArgsConstructor
public class MotoristaSpecification {
    public Specification<Motorista> filterText(String texto) {
        String finalText = "%" + texto + "%";
        //return (root, query, criteriaBuilder) -> {
        //    criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), finalText.toLowerCase());
        //    criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), finalText.toLowerCase());
        //    criteriaBuilder.like(criteriaBuilder.lower(root.get("telefone")), finalText.toLowerCase());
        //    return criteriaBuilder.conjunction();
        //};

        return (root, query, criteriaBuilder) -> criteriaBuilder.or(
                criteriaBuilder.like(criteriaBuilder.lower(root.get("nome")), finalText.toLowerCase()),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("email")), finalText.toLowerCase()),
                criteriaBuilder.like(criteriaBuilder.lower(root.get("telefone")), finalText.toLowerCase())
        );
    }

    public static Specification<Motorista> teste(String texto) {
        String finalText = "%" + texto + "%";
        return (root, query, criteriaBuilder) -> criteriaBuilder.between(root.get("preco"), 0, 100);
    }
}
