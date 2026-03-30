import { useNavigate } from 'react-router-dom';

const Home = () => {
    const navigate = useNavigate();

    return (
        <div className="home-hero">
            <div className="hero-content">
                <h1>AZURIMMO <span className="gold-text"></span></h1>
                <p>L'excellence de la gestion immobilière digitale.</p>
                <button className="btn-gold-home" onClick={() => navigate('/appartements')}>
                    Accéder au Parc Immobilier
                </button>
            </div>

            <style>{`
                .home-hero {
                    height: 85vh;
                    display: flex;
                    align-items: center;
                    justify-content: center;
                    text-align: center;
                    background-color: var(--bg-dark);
                    font-family: inherit;
                }

                .hero-content h1 { 
                    font-size: 6rem;
                    font-weight: 800;
                    letter-spacing: 12px; 
                    margin-bottom: 20px; 
                    text-transform: uppercase;
                    color: #ffffff;
                    line-height: 1.1;
                }

                .hero-content p { 
                    font-size: 1.6rem; 
                    color: var(--text-muted); 
                    margin-bottom: 50px; 
                    letter-spacing: 3px; 
                    font-weight: 300;
                }

                /* Bouton corrigé pour éviter l'effet "noir sur noir" */
                .btn-gold-home {
                    background-color: var(--gold) !important;
                    color: #000000 !important; /* Texte noir bien lisible sur l'or */
                    border: none;
                    padding: 20px 50px;
                    font-size: 1.1rem;
                    font-weight: 700;
                    text-transform: uppercase;
                    letter-spacing: 3px;
                    cursor: pointer;
                    transition: all 0.4s cubic-bezier(0.4, 0, 0.2, 1);
                    border-radius: 4px;
                    box-shadow: 0 4px 15px rgba(0,0,0,0.3);
                }

                .btn-gold-home:hover {
                    /* On passe sur un or plus clair/brillant au lieu de noir */
                    background-color: #f1d592 !important; 
                    transform: translateY(-5px);
                    /* Effet néon qui rappelle ta navbar */
                    box-shadow: 0 10px 30px var(--gold-glow);
                    letter-spacing: 4px; /* Petit effet d'expansion luxe */
                }

                @media (max-width: 768px) {
                    .hero-content h1 { font-size: 3rem; letter-spacing: 5px; }
                    .hero-content p { font-size: 1.1rem; }
                    .btn-gold-home { padding: 15px 30px; font-size: 0.9rem; }
                }
            `}</style>
        </div>
    );
};

export default Home;