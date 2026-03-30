import { BrowserRouter as Router, Routes, Route, Link } from 'react-router-dom';
import Home from './pages/Home';
import PageListeAppartements from './pages/PageListeAppartements';

function App() {
    return (
        <Router>
            <nav className="main-nav">
                <Link to="/" className="nav-logo">AZURIMMO</Link>
                <div className="nav-links">
                    <Link to="/">Accueil</Link>
                    <Link to="/appartements">Appartements</Link>
                </div>
            </nav>

            <Routes>
                <Route path="/" element={<Home />} />
                <Route path="/appartements" element={<PageListeAppartements />} />
            </Routes>

            <style>{`
                /* Configuration de la barre de navigation */
                .main-nav { 
                    display: flex; 
                    justify-content: space-between; 
                    align-items: center;
                    padding: 30px 80px; 
                    background-color: var(--bg-dark);
                    border-bottom: 1px solid var(--border); 
                    /* On s'assure que la nav hérite de la police globale */
                    font-family: inherit;
                }

                .nav-logo { 
                    font-size: 1.6rem; 
                    color: var(--gold); 
                    font-weight: 800; /* Très gras pour le style Apple */
                    text-decoration: none; 
                    letter-spacing: 4px; 
                    text-transform: uppercase;
                    font-family: inherit;
                }

                .nav-links {
                    display: flex;
                    gap: 40px;
                }

                .nav-links a { 
                    color: #ffffff; 
                    text-decoration: none; 
                    font-size: 1rem; 
                    font-weight: 500;
                    letter-spacing: 0.5px;
                    transition: color 0.3s ease;
                    font-family: inherit;
                }

                .nav-links a:hover { 
                    color: var(--gold); 
                }

                /* Suppression des marges parasites */
                * {
                    box-sizing: border-box;
                }
            `}</style>
        </Router>
    );
}

export default App;