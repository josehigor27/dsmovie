import FormCard from 'components/FormCard';
import { useParams } from 'react-router-dom';

function Forms() {

    const params = useParams();


    return (
        <FormCard movieId = {`${params.movieId}`} />
    );
}

export default Forms;