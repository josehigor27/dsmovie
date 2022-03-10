import { ReactComponent as IconGitHub } from '../../assets/img/iconGitHub.svg';
import './styles.css'

function NavBar() {
    return (
        <header>
            <nav className="container">
                <div className="dsmovie-nav-content" > 
                    <h1>DSMOVIE</h1>
                    <a href="https://github.com/josehigor27">
                        <div className="dsmovie-contact-container">
                            <IconGitHub />
                            <p className="dsmovie-contact-link"> /José Higor</p>
                        </div>
                    </a>
                </div>
            </nav>
        </header>
    );
}

export default NavBar;