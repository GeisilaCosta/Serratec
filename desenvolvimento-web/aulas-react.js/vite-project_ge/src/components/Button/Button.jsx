import styles from "./button.modules.css";

// botao - title, valor, onclick;

export function Botao({ valor, onclick, title }) {
    return (
        <>
            <button
                title={title}
                id="button"
                className={styles.botaoBase}
                onClick={onclick}
            >
                {valor}
            </button>
        </>
    );
}
export default Button;