import { Link, useNavigate } from 'react-router-dom';
import { useAuth } from '../context/AuthContext';

export default function Navbar() {
  const {
    user,
    isAuthenticated,
    logout,
  } = useAuth();

  const navigate = useNavigate();

  const handleLogout = () => {
    logout();
    navigate('/login');
  };

  return (
    <nav
      style={{
        padding: '12px 20px',
        borderBottom: '1px solid #ddd',
        display: 'flex',
        alignItems: 'center',
        gap: 16,
      }}
    >
      <Link to="/courses">
        Danh sach mon hoc
      </Link>

      {isAuthenticated &&
        user?.role === 'ADMIN' && (
          <>
            <Link to="/admin/courses">
              Quan tri mon hoc
            </Link>

            <Link to="/admin/api-keys">
              Quan ly API Key
            </Link>
          </>
        )}

      {isAuthenticated &&
        user?.role === 'STUDENT' && (
          <Link to="/register-course">
            Dang ky mon hoc
          </Link>
        )}

      <div
        style={{
          marginLeft: 'auto',
          display: 'flex',
          alignItems: 'center',
          gap: 12,
        }}
      >
        {isAuthenticated ? (
          <>
            <span>
              Xin chao, {user?.username}
            </span>

            <span>
              ({user?.role})
            </span>

            <button onClick={handleLogout}>
              Dang xuat
            </button>
          </>
        ) : (
          <Link to="/login">
            Dang nhap
          </Link>
        )}
      </div>
    </nav>
  );
}